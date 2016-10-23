package entity;





import util.CONSTANTS;

import java.time.LocalDate;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class Listing {

    private String title = "listing";
    private int price=0;
    private final int currencyMultiplier=100;
    private LocalDate startDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private LocalDate endDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private String name;
    private String address;
    private String description;
    private Category category;
    private String website;
    private String featureType;
    private String phoneNumber;


    public double getPrice() {
        return (double) price/currencyMultiplier;
    }

    public void setPrice(double price){
        int intermediate = (int) (price * currencyMultiplier);
        System.out.print(intermediate);
        this.price = (int) (price * currencyMultiplier);
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






    public int getCurrencyMultiplier() {
        return currencyMultiplier;
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



    public Category getCategory() {
        return category;
    }



    public void setCategory(String category) {
        this.category = new Category(category);
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



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setSubCategories(){
//        category.a
    }


    @Override
    public String toString() {
        return getName()+", "+getDescription()+", "+getPrice()+", "+getAddress()+", "+getPhoneNumber()+", "+
                getCategory().getName()+", "+getFeatureType()+", "+getStartDate().toString()+", "+getEndDate().toString()+", "+getWebsite();
    }
}
