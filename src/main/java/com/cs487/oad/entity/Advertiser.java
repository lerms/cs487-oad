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
    private String name="";
    private String email="";
    private String phone ="";
    private String website ="";
    private String description="";

    public Advertiser() {}

    public Advertiser(String name, String email) {
        this.name =name;
        this.email = email;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("Advertiser[\tid=%s\tdescription=%s\tweblink=%s]\n",
                id, name, email);
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Object getWebsite() {
        return website;
    }

    public void setWebsite(String link){
        this.website =link;
    }
}
