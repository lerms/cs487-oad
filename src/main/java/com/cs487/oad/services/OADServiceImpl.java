package com.cs487.oad.services;

import com.cs487.oad.entity.*;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import com.cs487.oad.util.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public void saveListing(Listing listing) {
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
    public void saveAdvertiser(Advertiser advertiser) {
        advertiserRepository.save(advertiser);
    }


    @Override
    public void deleteListing(Listing listing) {
        listingRepository.delete(listing);
    }

    @Override
    public void deleteCategory(CategoryDTO categoryDto) {
        Category toCategory = new Category(categoryDto.getName(), null, categoryDto.getName().toLowerCase());
        categoryRepository.deleteCategory(toCategory.getSlug());
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


    public CategoryDTO categoryToDTO(Category category) {
        List<Category> subcategories = categoryRepository.findByParentId(category.getId());
        if (subcategories == null || subcategories.size() == 0) {
            return new CategoryDTO(category.getName(), new ArrayList<>());
        }

        List<CategoryDTO> dtoSubcategories = subcategories.stream()
                .map(this::categoryToDTO)
                .collect(Collectors.toList());

        List<String> dtoNames = dtoSubcategories.stream()
                .map(CategoryDTO::getName)
                .collect(Collectors.toList());

        return new CategoryDTO(category.getName(), dtoNames);

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
    public Category findCategoryBySlug(String slug) {
        return RepositoryUtils.checkFound(categoryRepository.findBySlugIgnoreCase(slug));
    }

    public Category findCategoryById(String id) {
        return RepositoryUtils.checkFound(categoryRepository.findById(id));
    }

    public void emptyCollectionsForTesting() {
        advertiserRepository.deleteAll();
        categoryRepository.deleteAll();
        listingRepository.deleteAll();
    }

    private Category dtoToCategory(CategoryDTO categoryDTO) {
        //now has a unique id generated by mongo
        final String slug = categoryDTO.getName().toLowerCase();
        Category main = categoryRepository.findBySlugIgnoreCase(slug);
        if (main == null) {
            main = new Category(categoryDTO.getName(), null, slug);
            main = categoryRepository.insertCategory(main);
        }
        final String parentId = main.getId();
        List<Category> children = categoryDTO.getSubcategories().stream()
                .map(name -> new Category(name, parentId, name.toLowerCase()))
                .collect(Collectors.toList());
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