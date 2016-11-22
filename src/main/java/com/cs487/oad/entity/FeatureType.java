package com.cs487.oad.entity;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.EnumUtils;

/**
 * Created by alexanderlerma on 11/14/16.
 */
public enum FeatureType {
    @SerializedName("normal")
    NORMAL("normal"),
    @SerializedName("category")
    CATEGORY("category"),
    @SerializedName("homepage")
    HOMEPAGE("homepage"),
    @SerializedName("undefined")
    UNDEFINED("undefined");

    private String featureType;

    FeatureType(String featureType) {
        this.featureType = featureType;
    }

    public static FeatureType fromString(String type) {
        for (FeatureType featureType : FeatureType.values()) {
            if (featureType.featureType.equals(type))
                return featureType;
        }
        return UNDEFINED;
    }

    public static boolean isValid(String type) {
        return fromString(type) != UNDEFINED || EnumUtils.isValidEnum(FeatureType.class, type);
    }

    public String getFeatureType() {
        return featureType;
    }

    @Override
    public String toString() {
        return getFeatureType();
    }
}
