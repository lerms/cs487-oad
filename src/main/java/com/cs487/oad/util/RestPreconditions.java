package com.cs487.oad.util;

/**
 * Created by alexanderlerma on 11/6/16.
 */
public class RestPreconditions {
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found in repositories.");
        }
        return resource;
    }

    private static class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}


