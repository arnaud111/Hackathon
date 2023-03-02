package com.greenring.hackathon.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://greenring:NBy6oNuUxH5N3nsg@greenring.hwedwp7.mongodb.net/");
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "greenring");
    }
}

