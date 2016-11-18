package com.cs487.oad.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by alexanderlerma on 11/6/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    private static final String DATABASE_NAME = "heroku_6hj7vqg5";

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI("mongodb://alex:dbpass@ds145295.mlab.com:45295/" + DATABASE_NAME));
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.cs487.oad";
    }
}s
