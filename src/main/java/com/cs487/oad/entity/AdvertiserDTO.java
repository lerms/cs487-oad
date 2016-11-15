package com.cs487.oad.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

/**
 * Created by alexanderlerma on 11/15/16.
 */
public class AdvertiserDTO {

    @Email
    private final String email;
    private final String name;
    private final String phone;
    @URL
    private final String website;

    public AdvertiserDTO(String email, String name, String phone, String website) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
