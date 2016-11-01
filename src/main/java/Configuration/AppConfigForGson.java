//package Configuration;
//
//
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
//
//
///**
// * Created by Jlarrieux on 10/17/2016.
// */
//
//@EnableAutoConfiguration
//@ComponentScan
//@EnableWebMvc
//public class AppConfigForGson extends WebMvcConfigurerAdapter {
//
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        GsonHttpMessageConverter msgConverter = new GsonHttpMessageConverter();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        msgConverter.setGson(gson);
//        converters.add(msgConverter);
//    }
//}
