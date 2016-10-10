<<<<<<< HEAD
package boundaries.RestControllers;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by Jeannius on 10/2/2016.
 */

@RestController
@EnableAutoConfiguration
public class test2 {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(test2.class, args);
    }



    @RequestMapping("/")
    String home() {
        return "hello world";
    }
}
=======
//package boundaries.RestControllers;
//
//
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//
///**
// * Created by Jeannius on 10/2/2016.
// */
//
//@RestController
//@EnableAutoConfiguration
//public class test2 {
//
//
//    @RequestMapping("/")
//    String home(){
//        return  "hello world";
//    }
//
//
//    public static void main(String[] args) throws Exception{
//        SpringApplication.run(test2.class, args);
//    }
//}
>>>>>>> 94428ce7b9bb273279e902ca53156cfc2acc50f9
