package com.cs487.oad.entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alexanderlerma on 11/23/16.
 */
public class LocationDTO {
    private final String city;
    private final List<String> neighborhoods;

    public LocationDTO(String city, List<String> neighborhoods) {
        this.city = city;
        this.neighborhoods = neighborhoods;
    }

    public String getCity() {
        return city;
    }

    public List<String> getNeighborhoods() {
        return Lists.newArrayList(neighborhoods);
    }
}
