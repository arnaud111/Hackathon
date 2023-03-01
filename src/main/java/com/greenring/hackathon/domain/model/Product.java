package com.greenring.hackathon.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {
    String _id;
    String name;
    Integer price;
}
