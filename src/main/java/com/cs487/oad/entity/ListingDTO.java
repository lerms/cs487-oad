package com.cs487.oad.entity;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * Created by alexanderlerma on 11/14/16.
 */
public class ListingDTO {
    private final String name;
    private final String advertiser;
    private final String image;
    private final String address;
    private final String city;
    private final String neighborhood;
    private final String phone;
    private final String description;
    private final String website;
    private final FeatureType featureType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final String startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final String endDate;
    private final String category;
    private final List<String> subcategories;

    public ListingDTO(String name, String advertiser, String image, String address, String city,
                      String neighborhood, String phone, String description, String website, FeatureType featureType,
                      String startDate, String endDate, String category, List<String> subcategories) {
        this.name = name;
        this.advertiser = advertiser;
        this.image = image;
        this.address = address;
        this.city = city;
        this.neighborhood = neighborhood;
        this.phone = phone;
        this.description = description;
        this.website = website;
        this.featureType = featureType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getSubcategories() {
        return Lists.newArrayList(subcategories);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("advertiser", advertiser)
                .append("image", image)
                .append("address", address)
                .append("city", city)
                .append("neighborhood", neighborhood)
                .append("phone", phone)
                .append("description", description)
                .append("website", website)
                .append("featureType", featureType)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("category", category)
                .toString();
    }
}
