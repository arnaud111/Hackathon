package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.TrashEntity;
import com.greenring.hackathon.database.entity.UserEntity;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrashRepository extends MongoRepository<TrashEntity, String> {
    Option<TrashEntity> findBy_id(UUID _id);
    Option<TrashEntity> deleteBy_id(UUID _id);
}
