package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.OutwardProfile;
import com.example.ItrackBackend.model.WatchlistProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistProfileRepository extends MongoRepository<WatchlistProfile, String> {

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<WatchlistProfile> findByAccountNumber(Long accountNo, Pageable pageable);


    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    List<WatchlistProfile> findByAccountNumber(Long accountNo);
}
