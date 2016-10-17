package boundaries.RestControllers;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




/**
 * Created by Jeannius on 10/2/2016.
 */

@SpringBootApplication
public class test2  {


//    @RequestMapping("/")
//    String home(){
//        return  "hello world";
//    }
//
//    @Path("/health")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response health(){
//        Object object = new Object();
////        object.addProperty("REd",5);
//        return buildResponseStatusOk200(5);
//    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(test2.class, args);
    }
}
