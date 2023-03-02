package com.greenring.hackathon.application.dto;

import java.util.Date;
import java.util.UUID;

public record TransactionDto(
        UUID _id,
        Date date,
        UUID product_id,
        UUID user_id
) {
}
