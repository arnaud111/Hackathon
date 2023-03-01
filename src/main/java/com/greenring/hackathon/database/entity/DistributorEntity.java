package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@Builder
@Getter
@Setter
@Document(collection = "distributor")
public class DistributorEntity {

    @Id
    String _id;
    String name;
    String room;
    List<ProductEntity> products;
}
