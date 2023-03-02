package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public record TransactionCreationDto(
        @JsonProperty("date") Date date,
        @JsonProperty("product_id") UUID product_id,
        @JsonProperty("user_id") UUID user_id
) {
}
