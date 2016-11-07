package com.cs487.oad.boundaries.RestControllers;



import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class AbstractRestController {

    Gson gson = new Gson();

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
