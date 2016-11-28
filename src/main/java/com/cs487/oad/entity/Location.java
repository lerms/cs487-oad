package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by alexanderlerma on 11/26/16.
 */
@Document(collection = "location")
public class Location extends OADEntity {


    private String city;
    private String neighborhood;

    public Location(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("city", city)
                .append("neighborhood", neighborhood)
                .toString();
    }
}
