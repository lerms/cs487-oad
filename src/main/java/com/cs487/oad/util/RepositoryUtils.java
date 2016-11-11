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
        Query query = Query.query(Criteria.where(QueryField.NAME.toString()).is(queryValue));
        return query;
    }

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found in repositories.");
        }
        return resource;
    }

    private static class ResourceNotFoundException extends RuntimeException {

        private ResourceNotFoundException(String message) {
            super(message);
        }
    }

    private static class QueryFieldUndefinedException extends RuntimeException {

        private QueryFieldUndefinedException(String message) {
            super(message);
        }
    }

}
