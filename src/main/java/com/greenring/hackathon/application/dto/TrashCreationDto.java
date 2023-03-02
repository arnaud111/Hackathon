package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record TrashCreationDto(
        @JsonProperty("site")String site,
        @JsonProperty("room")String room,
        @JsonProperty("color")String color
) {
}
