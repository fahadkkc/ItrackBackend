package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.InwardTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InwardTransactionRepository extends MongoRepository<InwardTransaction, String> {

    // Query for transactions where the account number matches either the originator's account number or the dynamic params account number
    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<InwardTransaction> findByAccountNumber(Long accountNo, Pageable pageable);
}
