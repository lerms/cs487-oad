package com.cs487.oad.util;

import com.google.common.base.Preconditions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by alexanderlerma on 11/8/16.
 */
public class RepositoryUtils <T, V> {

    public static <T> Query simpleQuery(QueryField queryField, T queryValue) {
        Preconditions.checkNotNull(queryField);
        Preconditions.checkNotNull(queryValue);
        if (queryField == QueryField.UNDEFINED)
            throw new QueryFieldUndefinedException("QueryField can not be UNDEFINED!");
        return Query.query(Criteria.where(queryField.toString()).is(queryValue));
    }

    public static Query categorySlugQuery(String slug) {
        return simpleQuery(QueryField.SLUG, slug.toLowerCase());
    }

    public static Query categoryIdQuery(String id) {
        return simpleQuery(QueryField.ID, id);
    }

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found in repositories.");
        }
        return resource;
    }

    public static final class ResourceNotFoundException extends RuntimeException {

        private ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public static final class QueryFieldUndefinedException extends RuntimeException {

        private QueryFieldUndefinedException(String message) {
            super(message);
        }
    }

}
