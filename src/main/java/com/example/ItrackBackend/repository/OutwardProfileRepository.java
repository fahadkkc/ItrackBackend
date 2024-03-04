package com.example.ItrackBackend.repository;

import com.example.ItrackBackend.model.BlacklistedProfile;
import com.example.ItrackBackend.model.OutwardProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutwardProfileRepository extends MongoRepository<OutwardProfile, String> {

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<OutwardProfile> findByAccountNumber(Long accountNo, Pageable pageable);
}
