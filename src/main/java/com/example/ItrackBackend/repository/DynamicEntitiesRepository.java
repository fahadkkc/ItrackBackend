package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.DynamicEntities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicEntitiesRepository extends MongoRepository<DynamicEntities,String> {
}
