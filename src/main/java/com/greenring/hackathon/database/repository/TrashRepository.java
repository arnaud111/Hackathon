package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.TrashEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrashRepository extends MongoRepository<TrashEntity, String> {
}
