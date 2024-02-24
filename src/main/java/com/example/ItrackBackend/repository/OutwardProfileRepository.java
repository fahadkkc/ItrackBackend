package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.OutwardProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutwardProfileRepository extends MongoRepository<OutwardProfile, String> {
}
