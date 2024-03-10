package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.Account;
import com.example.ItrackBackend.model.InwardTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<Account> findByAccountNumber(Long accountNo, Pageable pageable);

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    List<Account> findByAccountNumber(Long accountNo);
}
