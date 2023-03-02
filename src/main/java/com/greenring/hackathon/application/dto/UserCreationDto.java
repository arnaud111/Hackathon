package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record UserCreationDto(
        @JsonProperty("login")String login,
        @JsonProperty("password")String password,
        @JsonProperty("firstname")String firstname,
        @JsonProperty("lastname")String lastname
) {
}
