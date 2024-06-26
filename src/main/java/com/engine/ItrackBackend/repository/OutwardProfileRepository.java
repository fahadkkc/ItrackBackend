package com.engine.ItrackBackend.repository;

import com.engine.ItrackBackend.model.OutwardProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutwardProfileRepository extends MongoRepository<OutwardProfile, String> {

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    Page<OutwardProfile> findByAccountNumber(Long accountNo, Pageable pageable);

    @Query("{ $or: [ { 'originatorAccountNumber': ?0 }, { 'dynamicParams.accountNo': ?0 } ] }")
    List<OutwardProfile> findByAccountNumber(Long accountNo);
}
