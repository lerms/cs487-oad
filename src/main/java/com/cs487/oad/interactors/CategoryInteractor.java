package com.cs487.oad.interactors;



import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.SubCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class CategoryInteractor {


    private Map<Category, List<SubCategory>> map = new HashMap<>();



    public int getSize(){
        return map.size();
    }


    public void add(Category category, List<SubCategory> sub) {
        List<SubCategory> current;
        if(map.containsKey(category)) current = map.get(category);
        else current =new ArrayList<>();

        current.addAll(sub);
        map.put(category, current);
    }
}
