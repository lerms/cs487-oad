package com.cs487.oad.entity;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by alexanderlerma on 11/23/16.
 */
public class LocationDTO {
    private final String city;
    private final Set<String> neighborhoods;

    public LocationDTO(String city, Set<String> neighborhoods) {
        this.city = city;
        this.neighborhoods = neighborhoods;
    }

    public String getCity() {
        return city;
    }

    public Set<String> getNeighborhoods() {
        return Sets.newHashSet(neighborhoods);
    }
}
