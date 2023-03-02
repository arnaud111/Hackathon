package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class Transaction {
    @Builder.Default UUID _id = UUID.randomUUID();
    Date date;
    UUID product_id;
    UUID user_id;
}
