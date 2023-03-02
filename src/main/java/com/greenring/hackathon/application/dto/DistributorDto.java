package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.greenring.hackathon.domain.model.Product;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record DistributorDto(
        UUID _id,
        String name,
        String room,
        List<Product> products
) {
}
