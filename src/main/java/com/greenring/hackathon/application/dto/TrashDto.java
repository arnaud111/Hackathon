package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record TrashDto(
        UUID _id,
        String site,
        String room,
        String color
) {
}
