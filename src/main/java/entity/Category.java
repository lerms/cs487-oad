package entity;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
public class Category {

    String name;
//    HashMap<String, SubCategory> Subcategory = new HashMap<>();
//    private ImmutableMap<String, SubCategory> Subcategory ;




    public Category(String name){
        this.name = name;
    }

//    public void add(String subCaterogryName ){
//        SubCategory sub;
//        if(Subcategory.containsKey(subCaterogryName)) {
//            sub =  Subcategory.get(subCaterogryName);
//
//        }else{
//            sub = new SubCategory(subCaterogryName);
//        }
//        sub.add(l);
//    }

    public String getName(){
        return  name;
    }

    public void print(){

    }

//    public HashMap<String, SubCategory> getSubcategoryMap(){
//        return Subcategory;
//    }

}
