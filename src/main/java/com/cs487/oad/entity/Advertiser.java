package com.cs487.oad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection="advertiser")
public class Advertiser extends OADEntity {

    private String description;
    private String webLink;

    public Advertiser() {}

    public Advertiser(String description, String webLink) {
        this.description = description;
        this.webLink = webLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String toString() {
        return String.format("Advertiser[\tid=%s\tdescription=%s\tweblink=%s]\n",
                id, description, webLink);
    }
}
