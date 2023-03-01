package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@Getter
@Setter
@Document(collection = "user")
public class UserEntity {

    @Id
    String _id;
    String login;
    String password;
    Integer coins = 0;
    String firstname;
    String lastname;
}
