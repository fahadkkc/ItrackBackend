package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
