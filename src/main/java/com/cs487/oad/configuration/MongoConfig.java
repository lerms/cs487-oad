//package com.cs487.oad.configuration;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//
///**
// * Created by alexanderlerma on 11/6/16.
// */
//@Configuration
//public class MongoConfig extends AbstractMongoConfiguration {
//
//    private static final String DB_NAME = "heroku_6hj7vqg5";
//    private static final String URI = "mongodb://admin:dbpass@ds145295.mlab.com:45295/heroku_6hj7vqg5";
//
//    @Override
//    protected String getDatabaseName() {
//        return DB_NAME;
//    }
//
//    @Override
//    @Bean
//    public Mongo mongo() throws Exception {
//        return new MongoClient(new MongoClientURI(URI));
//    }
//}
