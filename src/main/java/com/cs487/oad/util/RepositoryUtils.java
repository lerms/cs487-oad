package com.cs487.oad.util;

import com.google.common.base.Preconditions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by alexanderlerma on 11/8/16.
 */
public class RepositoryUtils <T, V> {
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSluggedString(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static <T> Query simpleQuery(QueryField queryField, T queryValue) {
        Preconditions.checkNotNull(queryField);
        Preconditions.checkNotNull(queryValue);
        if (queryField == QueryField.UNDEFINED)
            throw new QueryFieldUndefinedException("QueryField can not be UNDEFINED!");
        return Query.query(Criteria.where(queryField.toString()).is(queryValue));
    }

    public static Query categorySlugQuery(String slug) {
        return simpleQuery(QueryField.SLUG, toSluggedString(slug));
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

    private static final class ResourceNotFoundException extends RuntimeException {

        private ResourceNotFoundException(String message) {
            super(message);
        }
    }

    private static final class QueryFieldUndefinedException extends RuntimeException {

        private QueryFieldUndefinedException(String message) {
            super(message);
        }
    }
}
