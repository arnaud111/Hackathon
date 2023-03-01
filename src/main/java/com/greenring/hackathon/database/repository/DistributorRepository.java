package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.DistributorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DistributorRepository extends CrudRepository<DistributorEntity, String> {
}
