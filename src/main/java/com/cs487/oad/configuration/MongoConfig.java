package com.cs487.oad.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by alexanderlerma on 11/6/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "heroku_6hj7vqg5";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("mongodb://heroku_6hj7vqg5:k0kalp52vee3jq4m2knm7v91q7@ds145295.mlab.com:45295/");
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.cs487.oad";
    }
}
