package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    String _id;
    String login;
    String password;
    @Builder.Default int coins = 0;
    String firstname;
    String lastname;
}
