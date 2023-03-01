package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@Getter
@Setter
@Document(collection = "product")
public class ProductEntity {
    @Id
    String _id;
    String name;
    int price;
}
