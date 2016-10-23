package boundaries.RestControllers;



import com.google.gson.JsonObject;
import entity.Listing;
import org.springframework.web.bind.annotation.*;
import util.FUNCTIONS;



/**
 * Created by Jeannius on 10/22/2016.
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController extends AbstractRestController{


    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";



    @PutMapping(value = "/listing")
    public @ResponseBody String addListing(@RequestBody String json){

        JsonObject object = getJsonObjectFromString(json);

        System.out.println(object);
        Listing listing = createListingFromJsonObject(object);
        FUNCTIONS.printToDebug("\n\n\n"+listing.toString());
        return "";
    }


    private Listing createListingFromJsonObject(JsonObject object){
        Listing listing = new Listing();
        listing.setName(getStringFromJsonObject(object, NAME));
        listing.setDescription(getStringFromJsonObject(object, DESCRIPTION));
        listing.setPrice(getDoubleFromJsonObject(object, PRICE));
        listing.setAddress(getStringFromJsonObject(object, ADDRESS));
        listing.setPhoneNumber(getStringFromJsonObject(object, PHONE));
//        listing.setCategory();


        return listing;
    }


}
