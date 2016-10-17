package entity;
import org.springframework.data.annotation.Id;
import util.CONSTANTS;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class Listing {


    private String  city;


    private final int currencyMultiplier = 100;

    @Id
    private String id;
    private String categoryId;
    private String name;
    private String address;
    private String phone;
    private String description;
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
        this.categoryId = category;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return Double.compare(listing.price, price) == 0 &&
                Objects.equals(name, listing.name) &&
                Objects.equals(address, listing.address) &&
                Objects.equals(phone, listing.phone) &&
                Objects.equals(description, listing.description) &&
                Objects.equals(categoryId, listing.categoryId) &&
                Objects.equals(website, listing.website) &&
                Objects.equals(featureType, listing.featureType) &&
                Objects.equals(startDate, listing.startDate) &&
                Objects.equals(endDate, listing.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phone, description, categoryId, website, featureType, price, startDate, endDate);
    }

    public String toString() {
        return String.format("Listing[\tname=%s\taddress=%s\tphone=%s\tdescription=%s\tcategory=%s\twebsite=%s\tfeatureType=%s]\n",
                name, address, phone, description, categoryId, website, featureType);
    }
}