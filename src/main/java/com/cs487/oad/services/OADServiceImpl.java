package com.cs487.oad.services;

import com.cs487.oad.entity.*;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import com.cs487.oad.repositories.LocationRepository;
import com.cs487.oad.util.QueryField;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {
    private final CategoryRepository categoryRepository;
    private final AdvertiserRepository advertiserRepository;
    private final LocationRepository locationRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository,
                          LocationRepository locationRepository, ListingRepository listingRepository) {
        Preconditions.checkContentsNotNull(Arrays.asList(categoryRepository, advertiserRepository, locationRepository, listingRepository));
        this.categoryRepository = categoryRepository;
        this.advertiserRepository = advertiserRepository;
        this.locationRepository = locationRepository;
        this.listingRepository = listingRepository;
    }


    @Override
    public void saveCategory(CategoryDTO categoryDto) {
        dtoToCategory(categoryDto);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.insertCategory(category);
    }


    @Override
    public void saveCategories(List<CategoryDTO> categories) {
        categories.forEach(this::saveCategory);
    }

    @Override
    public void saveAdvertiser(AdvertiserDTO advertiserDto) {
        Advertiser adv = dtoToAdvertiser(advertiserDto);
        advertiserRepository.save(adv);
    }

    @Override
    public void deleteCategory(CategoryDTO categoryDto) {
        categoryRepository.deleteCategory(categoryDto.getName().toLowerCase());
    }

    @Override
    public void deleteAdvertiser(Advertiser advertiser) {
        advertiserRepository.delete(advertiser);
    }

    @Override
    public void updateCategoryName(String slug, String newName) {
        categoryRepository.updateName(slug, newName);
    }

    @Override
    public void updateCategorySlug(String slug, String newSlug) {
        categoryRepository.updateSlug(slug, newSlug);
    }

    @Override
    public void updateAdvertiserName(String email, String newName) {
        Advertiser advertiser = RepositoryUtils.checkFound(advertiserRepository.findByEmail(email));
        advertiser.setName(newName);
        advertiserRepository.save(advertiser);
    }

    @Override
    public Map<String, List<LocationDTO>> findAllLocations() {
        List<Location> locations = RepositoryUtils.checkFound(locationRepository.findAll());
        return Collections.singletonMap(QueryField.LOCATIONS.toString(), locationsToDtos(locations));
    }
    @Override
    public List<CategoryDTO> findAllCategories() {
        List<Category> categories = RepositoryUtils.checkFound(categoryRepository.findAll());
        return categories
                .stream()
                .map(this::categoryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> findAllRootCategories() {
        List<Category> categories = RepositoryUtils.checkFound(categoryRepository.findAll());
        return categories.stream()
                .filter(cat -> cat.getParentId() == null)
                .map(this::categoryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertiserDTO> findAllAdvertisers() {
        return RepositoryUtils.checkFound(advertiserRepository.findAll())
                .stream()
                .map(this::advertiserToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Category findCategoryByName(String name) {
        return RepositoryUtils.checkFound(categoryRepository.findByName(name));
    }

    @Override
    public CategoryDTO findCategoryBySlug(String slug) {
        Category category = RepositoryUtils.checkFound(categoryRepository.findBySlugIgnoreCase(slug));
        return categoryToDTO(category);
    }

    @Override
    public void emptyCollectionsForTesting() {
        advertiserRepository.deleteAll();
        categoryRepository.deleteAll();
        listingRepository.deleteAll();
        locationRepository.deleteAll();
    }

    @Override
    public Map<FeatureType, List<ListingDTO>> findAllListings() {
        List<Listing> allListings = RepositoryUtils.checkFound(listingRepository.findAll());
        List<ListingDTO> dtos = listingsToDtos(allListings);
        return dtos.stream().collect(Collectors.groupingBy(ListingDTO::getFeatureType));

    }

    @Override
    public void saveListing(ListingDTO listingDTO) {
        Listing listing = dtoToListing(listingDTO);
        listingRepository.save(listing);
    }

    public Map<String, Object> listingsForHomepage() {
        List<Listing> allListings = RepositoryUtils.checkFound(listingRepository.findAll());
        return buildFormattedListingModel(allListings);
    }

    @Override
    public Map<String, Object> searchListings(ListingSearchRequest listingSearchRequest) {
        List<Listing> searchListings = listingRepository.search(listingSearchRequest);
        List<ListingDTO> listingDTOs = listingsToDtos(searchListings);
        ListingDTO randomHomepageListing = popRandomListing(RepositoryUtils.checkFound(
                listingRepository.findByFeatureType(FeatureType.HOMEPAGE)));

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("featured", randomHomepageListing);
        searchMap.put("listings", listingDTOs);
        return searchMap;
    }


    @Override
    public void updateListingName(String id, String newName) {
        Listing listing = RepositoryUtils.checkFound(listingRepository.findById(id));
        listing.setName(newName);
        listingRepository.save(listing);
    }

    public void deleteListing(Listing listing) {
        listingRepository.delete(listing);
    }

    private Map<String, Object> buildFormattedListingModel(List<Listing> listings) {
        Map<FeatureType, List<Listing>> groupedByFeatureType = listingsGroupedByFeatureType(listings);
        Map<String, Object> listingModel = new HashMap<>();
        listingModel.put("homeFeaturedListing", popRandomListing(groupedByFeatureType.get(FeatureType.HOMEPAGE)));

        List<Category> allCategories = categoryRepository.findAll();

        //now they're in name, subcategory format
        List<CategoryDTO> categoryRoots = allCategories
                .stream()
                .filter(cat -> cat.getParentId() == null)
                .map(this::categoryToDTO)
                .collect(Collectors.toList());


        List<CategoryListingDTO> modelCategories = categoryRoots.stream().map(root -> {

            List<Listing> categoryListings = listingRepository.findByCategory(root.getName());
            Map<FeatureType, List<Listing>> groupedByFeature = listingsGroupedByFeatureType(categoryListings);
            ListingDTO randomCategoryFeatured = popRandomListing(groupedByFeature.get(FeatureType.CATEGORY));

            List<SubcategoryListingDTO> subcatDtos = root
                    .getSubcategories()
                    .stream()
                    .map(subcatName -> {

                        Map<FeatureType, List<Listing>> subcatListings = categoryListings
                                .stream()
                                .filter(listing -> listing.getSubcategories()
                                        .stream()
                                        .anyMatch(subcat -> subcat.getName().equalsIgnoreCase(subcatName)))
                                .collect(Collectors.groupingBy(Listing::getFeatureType));

                        ListingDTO subCategoryFeaturedListing = popRandomListing(subcatListings.get(FeatureType.CATEGORY));

                        List<Listing> remaining = new ArrayList<>();

                        if (subcatListings.get(FeatureType.HOMEPAGE) != null) {
                            remaining.addAll(subcatListings.get(FeatureType.HOMEPAGE));
                        }

                        if(subcatListings.get(FeatureType.CATEGORY) != null) {
                            remaining.addAll(subcatListings.get(FeatureType.CATEGORY));
                        }

                        if(subcatListings.get(FeatureType.NORMAL) != null) {
                            remaining.addAll(subcatListings.get(FeatureType.NORMAL));
                        }

                        return new SubcategoryListingDTO(subcatName, subCategoryFeaturedListing, listingsToDtos(remaining));
                    })
                    .collect(Collectors.toList());

            return new CategoryListingDTO(root.getName(), randomCategoryFeatured, subcatDtos);

        }).collect(Collectors.toList());

        listingModel.put("categories", modelCategories);
        return listingModel;
    }


    private Map<FeatureType, List<Listing>> listingsGroupedByFeatureType(List<Listing> listings) {
        return listings
                .stream()
                .collect(Collectors.groupingBy(Listing::getFeatureType));
    }

    /**
     * Removes a random listing from a given list of listings
     * @param listings
     * @return
     */
    private ListingDTO popRandomListing(List<Listing> listings) {
        if(listings == null || listings.size() == 0)
            return null;

        int randomIdx = RepositoryUtils.randomListIndex(0, listings.size());

        Listing randomListing = listings.remove(randomIdx);
        return listingToDTO(randomListing);
    }

    private List<LocationDTO> locationsToDtos(List<Location> locations) {
        Map<String, List<Location>> groupedByCity = locations
                .stream()
                .collect(Collectors.groupingBy(Location::getCity));

        List<LocationDTO> locationDtos = new ArrayList<>();
        groupedByCity.forEach((city, locationList) -> {
            Set<String> uniqueNeighborhoods = new HashSet<>();
            locationList.forEach(loc -> uniqueNeighborhoods.add(loc.getNeighborhood()));
            locationDtos.add(new LocationDTO(city, Lists.sortedCopy(uniqueNeighborhoods)));
        });

        return locationDtos;
    }

    private AdvertiserDTO advertiserToDTO(Advertiser advertiser) {
        return new AdvertiserDTO(advertiser.getEmail(), advertiser.getName(), advertiser.getPhone(), advertiser.getWebsite());
    }

    private List<ListingDTO> listingsToDtos(List<Listing> listings) {
        return listings
                .stream()
                .map(this::listingToDTO)
                .collect(Collectors.toList());
    }


    private ListingDTO listingToDTO(Listing listing) {


        List<String> subcats = listing.getSubcategories()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());

        return new ListingDTO(
                listing.getName(),
                listing.getAdvertiser().getName(),
                listing.getImage(),
                listing.getAddress(),
                listing.getLocation().getCity(),
                listing.getLocation().getNeighborhood(),
                listing.getPhone(),
                listing.getDescription(),
                listing.getWebsite(),
                listing.getFeatureType(),
                listing.getStartDate().toString(),
                listing.getEndDate().toString(),
                listing.getCategory().getName(),
                subcats);
    }


    private CategoryDTO categoryToDTO(Category category) {
        List<Category> subcategories = categoryRepository.findByParentId(category.getId());

        if (subcategories == null || subcategories.size() == 0) {
            return new CategoryDTO(category.getName(), new ArrayList<>());
        }

        //we could return the full structure of subcategories using these dtos
        List<CategoryDTO> dtoSubcategories = subcategories.stream()
                .map(this::categoryToDTO)
                .collect(Collectors.toList());

        //but for now, the front-end only accepts a list of strings for subcategories
        List<String> dtoNames = dtoSubcategories.stream()
                .map(CategoryDTO::getName)
                .collect(Collectors.toList());

        return new CategoryDTO(category.getName(), dtoNames);

    }

    private Advertiser dtoToAdvertiser(AdvertiserDTO advertiserDto) {
        Preconditions.checkNotNull(advertiserDto);
        Advertiser advertiser = advertiserRepository.findByEmail(advertiserDto.getEmail());
        if (advertiser == null) {
            advertiser = new Advertiser();
            advertiser.setName(advertiserDto.getName());
            advertiser.setPhone(advertiserDto.getPhone());
            advertiser.setEmail(advertiserDto.getEmail());
            advertiser.setWebsite(advertiserDto.getWebsite());
            advertiser.setSlug(RepositoryUtils.toSluggedString(advertiser.getName()));
        }
        return advertiser;
    }

    private Listing dtoToListing(ListingDTO listingDto) {
        Preconditions.checkNotNull(listingDto);
        Preconditions.checkNotNull(listingDto.getCategory());

        Category category = RepositoryUtils.checkFound(categoryRepository.findByName(listingDto.getCategory()));

        List<Category> subcategories = listingDto.getSubcategories()
                .stream()
                .map(sub -> RepositoryUtils.checkFound(categoryRepository.findByName(sub)))
                .collect(Collectors.toList());

        Advertiser advertiser = RepositoryUtils.checkFound(advertiserRepository.findByName(listingDto.getAdvertiser()));

        List<Location> cityNeighborhoods = locationRepository.findByCity(listingDto.getCity());
        Location location = new Location(listingDto.getCity(), listingDto.getArea());
        //add the location to our repository
        if (cityNeighborhoods == null || cityNeighborhoods.size() == 0) {
            location = locationRepository.save(location);
        } else {
            // if the location exists, we'll use that, else add it to the repository
            location = cityNeighborhoods
                    .stream()
                    .filter(x -> x.getNeighborhood().equalsIgnoreCase(listingDto.getArea()))
                    .findFirst()
                    .orElse(locationRepository.save(location));
        }


        Listing listing = new Listing();

        listing.setCategory(category);
        listing.setSubcategories(subcategories);
        listing.setAdvertiser(advertiser);
        listing.setLocation(location);

        listing.setImage(listingDto.getImage());
        listing.setStartDate(LocalDate.parse(listingDto.getStartDate(), DateTimeFormatter.ISO_DATE));
        listing.setEndDate(LocalDate.parse(listingDto.getEndDate(), DateTimeFormatter.ISO_DATE));
        listing.setFeatureType(listingDto.getFeatureType());
        listing.setName(listingDto.getName());
        listing.setAddress(listingDto.getAddress());
        listing.setPhone(listingDto.getPhone());
        listing.setDescription(listingDto.getDescription());
        listing.setWebsite(listingDto.getWebsite());
        listing.setPhone(listingDto.getPhone());
        return listing;
    }

    private Category dtoToCategory(CategoryDTO categoryDto) {
        final String slug = RepositoryUtils.toSluggedString(categoryDto.getName());
        Category main = categoryRepository.findBySlugIgnoreCase(slug);
        if (main == null) {
            main = new Category(categoryDto.getName(), null, slug);
            //has a unique id generated by mongo after insert
            main = categoryRepository.insertCategory(main);
        }
        final String parentId = main.getId();
        List<Category> children = categoryDto.getSubcategories()
                .stream()
                .map(childName -> {
                    final String childSlug = RepositoryUtils.toSluggedString(childName);
                    Category childCategory = categoryRepository.findBySlugIgnoreCase(childSlug);
                    if (childCategory == null) {
                        Category newCategory = new Category(childName, parentId, childSlug);
                        return categoryRepository.insertCategory(newCategory);
                    }
                    categoryRepository.addCategoryAncestor(childCategory.getSlug(), slug);
                    return categoryRepository.findById(childCategory.getId());
                })
                .collect(Collectors.toList());
        return main;
    }
}