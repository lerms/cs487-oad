package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jlarrieux on 9/19/2016.
 */
@Document(collection = "advertiser")
public class Advertiser extends OADEntity {

    @Email
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String name;
    private String phone;
    private String website;
    private String slug;

    public Advertiser() {
    }

    public Advertiser(String name, String phone, String website, String email, String slug) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.email = email;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("phone", phone)
                .append("website", website)
                .append("email", email)
                .append("slug", slug)
                .toString();
    }
}
