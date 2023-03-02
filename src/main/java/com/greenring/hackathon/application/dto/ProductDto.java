package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record ProductDto(
        UUID _id,
        String name,
        Integer price
) {
}
