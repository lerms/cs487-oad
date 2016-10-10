package com.cs487oad.backend.entity;



import com.cs487oad.backend.util.CONSTANTS;

import java.time.LocalDate;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class Listing {

    private String name,description, city;
    private final int currencyMultiplier = 100;
    private int price = 0;
    private LocalDate startDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private LocalDate endDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);



    public double getPrice() {
        return (double) price / currencyMultiplier;
    }



    public void setPrice(double price) {
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



    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public String getDescription() {
        return description;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public String getCity() {
        return city;
    }
}
