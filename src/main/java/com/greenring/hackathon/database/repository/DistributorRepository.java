package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.DistributorEntity;
import com.greenring.hackathon.database.entity.UserEntity;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DistributorRepository extends MongoRepository<DistributorEntity, String> {
    Option<DistributorEntity> findBy_id(UUID _id);
}
