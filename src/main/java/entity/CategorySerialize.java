//package entity;
//
//
//
//import com.google.gson.*;
//
//import java.lang.reflect.Type;
//
//
//
///**
// * Created by Jlarrieux on 10/17/2016.
// */
//public class CategorySerialize implements JsonSerializer<Category> {
//
////
////    @Override
////    public JsonElement serialize(Category src, Type cateType, JsonSerializationContext context) {
////        JsonObject object = new JsonObject();
////        object.addProperty("Name", src.getName());
////        JsonArray array  = new JsonArray();
//////        array.add(object);
////
//////        for(String s: src.getSubcategoryMap().keySet()){
//////            JsonObject obj = new JsonObject();
//////            obj.addProperty("s1","test");
//////            obj.addProperty(s, src.getSubcategoryMap().get(s).toString());
//////            array.add(obj);
//////        }
////
////
////        return array;
////    }
//}
