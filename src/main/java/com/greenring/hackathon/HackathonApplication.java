package com.greenring.hackathon;

import com.greenring.hackathon.application.ApplicationConfiguration;
import com.greenring.hackathon.database.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Import({ApplicationConfiguration.class, MongoConfig.class})
@SpringBootApplication(scanBasePackages = "com.greenring.hackathon")
@EnableMongoRepositories
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

}
