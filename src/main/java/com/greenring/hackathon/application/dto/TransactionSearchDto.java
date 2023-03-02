package com.greenring.hackathon.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record TransactionSearchDto(
        @JsonProperty("startDate") Date startDate,
        @JsonProperty("endDate")Date endDate
) {
}
