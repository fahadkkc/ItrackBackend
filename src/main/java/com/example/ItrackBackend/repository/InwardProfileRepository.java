package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.BlacklistedProfile;
import com.example.ItrackBackend.model.InwardProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InwardProfileRepository extends MongoRepository<InwardProfile, String> {

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<InwardProfile> findByAccountNumber(Long accountNo, Pageable pageable);


    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    List<InwardProfile> findByAccountNumber(Long accountNo);

}
