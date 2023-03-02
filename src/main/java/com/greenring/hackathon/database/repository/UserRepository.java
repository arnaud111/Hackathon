package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
