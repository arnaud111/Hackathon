package com.greenring.hackathon.controller.user.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    String login;
    String password;
    String firstname;
    String lastname;
}
