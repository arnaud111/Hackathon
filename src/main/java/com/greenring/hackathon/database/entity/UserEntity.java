package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Value
@Builder
@Getter
@Setter
@Document(collection = "users")
public class UserEntity {

    @Id UUID _id;
    String login;
    String password;
    Integer coins;
    String firstname;
    String lastname;
    Boolean admin;
}
