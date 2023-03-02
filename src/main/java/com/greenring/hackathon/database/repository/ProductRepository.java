package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.ProductEntity;
import com.greenring.hackathon.database.entity.UserEntity;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    Option<ProductEntity> findBy_id(UUID _id);
}
