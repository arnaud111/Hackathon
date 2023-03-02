package com.greenring.hackathon.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
@Getter
@Setter
@Document(collection = "transactions")
public class TransactionEntity {
    @Id UUID _id;
    Date date;
    UUID product_id;
    UUID user_id;
}
