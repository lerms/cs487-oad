package com.cs487.oad.interactors;



import com.cs487.oad.entity.Category;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class CategoryInteractor {


    private Map<String, Category> map = new HashMap<>();



    //Initialization-on-Demand Holder Idiom
    //see wikipedia: https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    //and this blog post for explanation http://blog.crazybob.org/2007/01/lazy-loading-singletons.html
    private static class CategoryHolder{
        public static CategoryInteractor INSTANCE = new CategoryInteractor();
    }

    public static CategoryInteractor getInstance(){
        return CategoryHolder.INSTANCE;
    }


    private CategoryInteractor(){

    }
//***end of IODH

    public int getSize(){
        return map.size();
    }


//    public void add(Category category, String name) {
////        List<SubCategory> current;
////        if(map.containsKey(category)) current = map.get(category);
////        else current =new ArrayList<>();
////
////        current.addAll(sub);
////        map.put(category, current);
//        map.put(name, category);
//
//    }

    public void add(Category category){
        map.put(category.getName(), category);
    }

    public Category getCategory(String name){
        return map.get(name);
    }


}
