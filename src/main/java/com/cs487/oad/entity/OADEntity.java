package com.cs487.oad.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by alexanderlerma on 11/6/16.
 */

public class OADEntity {

    @Id
    protected String id;

    public String getId() {
        return id;
    }

}
