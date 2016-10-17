package entity;



import java.util.HashMap;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
public class Category {

    String name;
    HashMap<String, SubCategory> Subcategory = new HashMap<>();
//    private ImmutableMap<String, SubCategory> Subcategory ;
    Arrayl


    public Category(String name){
        this.name = name;
    }

    public void add(String catName , Listing l){
        SubCategory sub;
        if(Subcategory.containsKey(catName)) {
            sub =  Subcategory.get(catName);

        }else{
            sub = new SubCategory(catName);
        }
        sub.add(l);
    }

    public String getName(){
        return  name;
    }

    public void print(){

    }

    public HashMap<String, SubCategory> getSubcategoryMap(){
        return Subcategory;
    }

}
