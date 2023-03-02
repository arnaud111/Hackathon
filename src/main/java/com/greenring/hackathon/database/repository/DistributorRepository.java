package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.DistributorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistributorRepository extends MongoRepository<DistributorEntity, String> {
}
