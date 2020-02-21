package com.example.servingwebcontent;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoConnection {

    private static MongoOperations mongoOps;

    public static MongoOperations getInstance() {
        if(mongoOps==null) mongoOps = new MongoTemplate(MongoClients.create(), "tests");
        return mongoOps;
    }
}
