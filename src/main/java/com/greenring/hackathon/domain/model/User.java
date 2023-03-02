package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class User {
    @Builder.Default UUID _id = UUID.randomUUID();
    String login;
    String password;
    @Builder.Default Integer coins = 0;
    String firstname;
    String lastname;
    @Builder.Default Boolean admin = false;
}
