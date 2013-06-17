package com.skplanet.sqe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skplanet.sqe.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
