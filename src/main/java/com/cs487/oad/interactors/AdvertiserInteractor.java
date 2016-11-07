package com.cs487.oad.interactors;



import com.cs487.oad.entity.Advertiser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by Jeannius on 11/6/2016.
 */
public class AdvertiserInteractor {

    private static Map<String, Advertiser> map= new HashMap<>();
    private static AdvertiserInteractor advertiserInteractor = new AdvertiserInteractor();

   //Initialization-on-Demand Holder Idiom
    //see wikipedia: https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    //and this blog post for explanation http://blog.crazybob.org/2007/01/lazy-loading-singletons.html
    private static class AdvertiserHolder{
        public static AdvertiserInteractor INSTANCE = new AdvertiserInteractor();
    }

    public static AdvertiserInteractor getInstance(){
        return AdvertiserHolder.INSTANCE;
    }


    private AdvertiserInteractor(){

    }
//***end of IODH




    public void add(Advertiser ad) {
        map.put(ad.getEmail(), ad);
    }


    public int getSize() {
        return map.size();
    }



    public Collection<Advertiser> getAll() {
        return  map.values();
    }




}
