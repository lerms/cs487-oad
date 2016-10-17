package entity;



import java.util.ArrayList;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
public class SubCategory {
    String title="Subcategory";
    private String name;
    ArrayList<Listing> subCategories = new ArrayList<>();


    public SubCategory(String n){
        name =n;
    }

    public void add(Listing l){
        subCategories.add(l);
    }

    public int getSize(){
        return subCategories.size();
    }


}
