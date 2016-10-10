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

<<<<<<< HEAD
    private String name,description, city;
    private final int currencyMultiplier = 100;
    private int price = 0;
=======
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
>>>>>>> 94428ce7b9bb273279e902ca53156cfc2acc50f9
    private LocalDate startDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);
    private LocalDate endDate = LocalDate.from(CONSTANTS.DEFAULT_DATE);


<<<<<<< HEAD

    public double getPrice() {
        return (double) price / currencyMultiplier;
    }



    public void setPrice(double price) {
        int intermediate = (int) (price * currencyMultiplier);
        System.out.print(intermediate);
        this.price = (int) (price * currencyMultiplier);
=======
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
>>>>>>> 94428ce7b9bb273279e902ca53156cfc2acc50f9
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

<<<<<<< HEAD


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
=======
    public String toString() {
        return String.format("Listing[\nname=%s\naddress=%s\nphone=%s\ndescription=%s\ncategory=%s\nwebsite=%s\nfeatureType=%s]",
                name, address, phone, description, category, website, featureType);
>>>>>>> 94428ce7b9bb273279e902ca53156cfc2acc50f9
    }
}
