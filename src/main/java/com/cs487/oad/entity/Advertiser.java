package com.cs487.oad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection="advertiser")
public class Advertiser {

    @Id
    private String id;
    private String description="";
    private String email="";

    public Advertiser() {}

    public Advertiser(String description, String email) {
        this.description = description;
        this.email = email;
    }

    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("Advertiser[\tid=%s\tdescription=%s\tweblink=%s]\n",
                id, description, email);
    }
}
