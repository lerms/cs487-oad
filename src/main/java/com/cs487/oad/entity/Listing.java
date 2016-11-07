package com.cs487.oad.entity;



import com.cs487.oad.util.CONSTANTS;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection="listing")
public class Listing extends OADEntity {

    private final int currencyMultiplier = 100;
    private String categoryId;
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

    public Listing() {}

    public Listing(String categoryId, String name, String address, String phone, String description,
                   String website, String featureType, String city,
                   double price, LocalDate startDate, LocalDate endDate) {
        this.categoryId = categoryId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.website = website;
        this.featureType = featureType;
        this.city = city;
        setPrice(price);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getPrice() {
        return (double) price / currencyMultiplier;
    }

    public void setPrice(double price){
        int intermediate = (int) (price * currencyMultiplier);
        this.price = intermediate;

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


    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public int getCurrencyMultiplier() {
        return currencyMultiplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategory(String categoryId) {
        this.categoryId = categoryId;
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


    public String toString() {
        return String.format("Listing[\tname=%s\taddress=%s\tphone=%s\tdescription=%s\tcategory=%s\twebsite=%s\tfeatureType=%s]\n",
                name, address, phone, description, categoryId, website, featureType);
    }
}