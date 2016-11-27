package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection = "listing")
public class Listing extends OADEntity {

    private final int currencyMultiplier = 100;
    private int price;
    private String name;
    @DBRef
    private Advertiser advertiser;
    private String image;
    private String address;
    @DBRef
    private Location location;
    private String phone;
    private String description;
    @URL
    private String website;
    private FeatureType featureType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
    @DBRef
    private Category category;

    public Listing() {
    }

    @PersistenceConstructor
    public Listing(String name, Advertiser advertiser, String image,
                   String address, Location location, String phone,
                   String description, String website, FeatureType featureType,
                   LocalDate startDate, LocalDate endDate, Category category, double price) {
        this.name = name;
        this.advertiser = advertiser;
        this.image = image;
        this.address = address;
        this.location = location;
        this.phone = phone;
        this.description = description;
        this.website = website;
        this.featureType = featureType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return (double) price / currencyMultiplier;
    }

    public void setPrice(double price) {
        int intermediate = (int) (price * currencyMultiplier);
        this.price = intermediate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("price", price)
                .append("name", name)
                .append("advertiser", advertiser)
                .append("image", image)
                .append("address", address)
                .append("location", location)
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