package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.InwardTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InwardTransactionRepository extends MongoRepository<InwardTransaction, String> {
}
