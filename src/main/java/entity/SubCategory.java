package entity;



import java.util.ArrayList;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
public class SubCategory {

    ArrayList<Listing> listings = new ArrayList<>();
    private String name;

    public SubCategory(String n){
        name =n;
    }

    public void add(Listing l){
        listings.add(l);
    }

    public int getSize(){
        return listings.size();
    }


}
