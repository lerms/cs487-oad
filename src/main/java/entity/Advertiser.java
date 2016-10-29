package entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document
public class Advertiser {

    @Id
    private String id;
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
