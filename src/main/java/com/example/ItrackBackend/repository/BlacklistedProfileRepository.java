package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.BlacklistedProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlacklistedProfileRepository extends MongoRepository<BlacklistedProfile, String> {
}
