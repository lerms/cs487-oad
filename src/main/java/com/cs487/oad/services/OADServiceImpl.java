package com.cs487.oad.services;

import com.cs487.oad.entity.*;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {
    private final CategoryRepository categoryRepository;
    private final AdvertiserRepository advertiserRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository,
                          ListingRepository listingRepository) {
        Assert.notNull(categoryRepository);
        Assert.notNull(advertiserRepository);
        Assert.notNull(listingRepository);
        this.categoryRepository = categoryRepository;
        this.advertiserRepository = advertiserRepository;
        this.listingRepository = listingRepository;
    }


    @Override
    public void saveListing(ListingDTO listingDto) {
        Listing listing = dtoToListing(listingDto);
        listingRepository.save(listing);
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
    public void deleteListing(Listing listing) {
        listingRepository.delete(listing);
    }

    @Override
    public void deleteCategory(CategoryDTO categoryDto) {
        categoryRepository.deleteCategory(categoryDto.getName().toLowerCase());
    }

    @Override
    public void deleteAdvertiser(Advertiser advertiser) {
        advertiserRepository.delete(advertiser);
    }


    public void updateListingName(String id, String newName) {
        Listing listing = RepositoryUtils.checkFound(listingRepository.findById(id));
        listing.setName(newName);
        listingRepository.save(listing);
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
    public List<Listing> findAllListings() {
        return RepositoryUtils.checkFound(listingRepository.findAll());
    }

    @Override
    public List<ListingDTO> findAllListingsAsDtos() {
        List<Listing> listings = findAllListings();
//        return listings.stream().map(this::listingToDto).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = RepositoryUtils.checkFound(categoryRepository.findAll());
        return categories;
    }

    public List<CategoryDTO> findAllCategoriesAsDtos() {
        List<Category> categories = findAllCategories();
        List<CategoryDTO> categoryDtos = categories.stream()
                .map(this::categoryToDTO)
                .collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public List<Advertiser> findAllAdvertisers() {
        return RepositoryUtils.checkFound(advertiserRepository.findAll());
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

    public Category findCategoryById(String id) {
        return RepositoryUtils.checkFound(categoryRepository.findById(id));
    }

    public void emptyCollectionsForTesting() {
        advertiserRepository.deleteAll();
        categoryRepository.deleteAll();
        listingRepository.deleteAll();
    }
//
//    private ListingDTO listingToDTO(Listing listing) {
//        ListingDTO dto = new ListingDTO(listing.getName())
//    }

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
        Category category = RepositoryUtils.checkFound(categoryRepository
                .findBySlugIgnoreCase(RepositoryUtils.toSluggedString(listingDto.getCategory())));
        Advertiser advertiser = RepositoryUtils.checkFound(advertiserRepository.findByName(listingDto.getAdvertiser()));
        Listing listing = new Listing();
        listing.setCategory(category);
        listing.setAdvertiser(advertiser);
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
        listing.setCity(listingDto.getCity());
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
        //create Category objects from the names
        List<Category> children = categoryDto.getSubcategories().stream()
                .map(name -> new Category(name, parentId, RepositoryUtils.toSluggedString(name)))
                .collect(Collectors.toList());
        //replace the newly created category with an existing version if available
        children = children.stream()
                .map(child -> {
                    Category found = categoryRepository.findBySlugIgnoreCase(child.getSlug());
                    if (found == null)
                        return categoryRepository.insertCategory(child);
                    categoryRepository.addCategoryAncestor(found.getSlug(), slug);
                    return categoryRepository.findBySlugIgnoreCase(found.getSlug());
                })
                .collect(Collectors.toList());
        return main;
    }
}