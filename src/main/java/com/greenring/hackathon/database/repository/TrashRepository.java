package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.TrashEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrashRepository extends CrudRepository<TrashEntity, String> {
}
