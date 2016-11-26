package com.cs487.oad.configuration;



import com.cs487.oad.controllers.indexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * Created by Jeannius on 11/26/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.cs487.oad")
public class WebConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/static/");
    }


    @Bean
    public indexController indexController(){
        return new indexController();
    }



}
