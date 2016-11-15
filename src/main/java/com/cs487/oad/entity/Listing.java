package com.cs487.oad.entity;


import com.cs487.oad.util.CONSTANTS;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection = "listing")
public class Listing extends OADEntity {

    private final int currencyMultiplier = 100;
    @DBRef
    private Category category;
    private String name;
    private String address;
    private String phone;
    private String description;
    private String website;
    private String featureType;
    private String city;
    private String phoneNumber;
    private int price;
    private LocalDate startDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private LocalDate endDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);

    public Listing() {
    }

    public Listing(Category category, String name, String address, String phone,
                   String description, String website, String featureType, String city, String phoneNumber,
                   int price, LocalDate startDate, LocalDate endDate) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.website = website;
        this.featureType = featureType;
        this.city = city;
        this.phoneNumber = phoneNumber;
        setPrice(price);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getPrice() {
        return (double) price / currencyMultiplier;
    }

    public void setPrice(double price) {
        int intermediate = (int) (price * currencyMultiplier);
        this.price = intermediate;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return getName()+", "+getDescription()+", " +getPrice()+", "+getAddress()+", "+getPhoneNumber() +", "+", "+getStartDate().toString()+", "+getEndDate().toString()+", "+getWebsite();
    }


}