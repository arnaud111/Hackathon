package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {
}
