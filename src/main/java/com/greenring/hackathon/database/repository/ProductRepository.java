package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
