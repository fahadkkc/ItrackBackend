package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.InwardProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InwardProfileRepository extends MongoRepository<InwardProfile, String> {
}
