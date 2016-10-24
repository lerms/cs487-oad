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


    @RequestMapping("/")
    String home(){
        return  "<p>hello world</p><p>Salut au monde</p><p>Hola Mundo</p><p>Allo a tout moun</p><p>Wha gwaan to di world</p>";
    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(test2.class, args);
    }
}
