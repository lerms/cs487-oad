package com.cs487.oad.util;

import org.apache.commons.lang3.EnumUtils;
import
/**
 * Created by alexanderlerma on 11/8/16.
 */
public enum QueryField {

    NAME("name"),
    SLUG("slug"),
    ID("id"),
    DESCRIPTION("description"),
    PRICE("price"),
    ADDRESS("address"),
    PHONE("phone"),
    CATEGORY("category"),
    FEATURE_TYPE("featureType"),
    WEBSITE("website"),
    ANCESTORS("ancestors"),
    CITY("city"),
    START_DATE("startDate"),
    END_DATE("endDate"),
    PARENT_ID("parentId"),
    LOCATIONS("locations"),
    UNDEFINED("undefined");

    private final String field;

    QueryField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }

    public static QueryField fromString(String field) {
        for (QueryField queryField : QueryField.values()) {
            if (queryField.field.equals(field))
                return queryField;
        }
        return UNDEFINED;
    }

    public static boolean isValid(String field) {
        return fromString(field) != UNDEFINED || EnumUtils.isValidEnum(QueryField.class, field);
    }

}
