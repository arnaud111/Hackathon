package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Product {
    @Builder.Default UUID _id = UUID.randomUUID();
    String name;
    Integer price;
}
