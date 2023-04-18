package com.interview.carprocurement.repository;

import com.interview.carprocurement.data.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, String> {
    Optional<TransactionRecord> findById(String id);

    Optional<TransactionRecord> findByCarId(String id);

}