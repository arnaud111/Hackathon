package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.ProductEntity;
import com.greenring.hackathon.database.entity.TransactionEntity;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    Option<TransactionEntity> findBy_id(UUID _id);
}
