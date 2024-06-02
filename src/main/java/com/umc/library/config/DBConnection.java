package com.umc.library.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    private static MongoDatabase mongoDatabase = null;

    public static MongoDatabase getMongoDatabase() {
        if (mongoDatabase == null) {
            mongoDatabase = MongoClients.create().getDatabase("library");
        }
        return mongoDatabase;
    }
}
