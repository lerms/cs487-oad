package entity;



import java.util.ArrayList;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
public class Category {

    ArrayList<SubCategory> categories= new ArrayList<>();
    String name;

    public Category(String name){
        this.name = name;
    }

    public void add(SubCategory c){
        categories.add(c);
    }

    public int getSize(){
        return categories.size();
    }

    public String getName(){
        return  name;
    }

    public void print(){

    }

}
