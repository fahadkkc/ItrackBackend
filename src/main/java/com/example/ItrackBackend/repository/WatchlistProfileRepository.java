package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.WatchlistProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WatchlistProfileRepository extends MongoRepository<WatchlistProfile, String> {
}
