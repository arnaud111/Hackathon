package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record ProductCreationDto(
        @JsonProperty("name")String name,
        @JsonProperty("price")Integer price
) {
}
