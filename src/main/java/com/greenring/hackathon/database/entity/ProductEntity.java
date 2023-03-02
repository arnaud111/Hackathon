package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Value
@Builder
@Getter
@Setter
@Document(collection = "products")
public class ProductEntity {
    @Id
    UUID _id;
    String name;
    Integer price;
}
