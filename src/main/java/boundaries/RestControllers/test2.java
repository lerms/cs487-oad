
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

