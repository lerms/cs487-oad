package com.cs487.oad.controllers;



import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.CategoryDTO;
import com.cs487.oad.services.OADService;
import com.google.gson.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jeannius on 10/22/2016.
 */
public abstract class OADRestController {

    protected final OADService oadService;
    private Gson gson;

    protected OADRestController(OADService oadService) {
        this.oadService = oadService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    protected String getStringFromJson(String json) {
        return gson.fromJson(json, String.class);
    }

    protected JsonObject getJsonObjectFromString(String s){
        JsonElement element = new JsonParser().parse(s);
        return element.getAsJsonObject();
    }

    protected String getStringFromJsonObject(JsonObject jsonObject, String key){

        return jsonObject.getAsJsonPrimitive(key).getAsString();
    }

    protected double getDoubleFromJsonObject(JsonObject jsonObject, String key){
        return jsonObject.getAsJsonPrimitive(key).getAsDouble();
    }

}
