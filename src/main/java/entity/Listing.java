package entity;

import org.springframework.data.annotation.Id;
import util.CONSTANTS;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class Listing {

    private final int currencyMultiplier = 100;

    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
    private String description;
    private String category;
    private String website;
    private String featureType;
    private double price;
    private LocalDate startDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private LocalDate endDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);


    public Listing() {}

    public Listing(String name, String address, String phone, String description,
                   String category, String website, String featureType, double price) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.category = category;
        this.website = website;
        this.featureType = featureType;
        setPrice(price);
    }

    public double getPrice() {
        return price/currencyMultiplier;
    }

    public void setPrice(double price){
        this.price = price * currencyMultiplier;
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

    public String toString() {
        return String.format("Listing[\nname=%s\naddress=%s\nphone=%s\ndescription=%s\ncategory=%s\nwebsite=%s\nfeatureType=%s]",
                name, address, phone, description, category, website, featureType);
    }
}
