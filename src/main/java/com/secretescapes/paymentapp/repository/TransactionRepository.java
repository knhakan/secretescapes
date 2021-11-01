package com.secretescapes.paymentapp.repository;

import com.secretescapes.paymentapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "select * from transaction where from_account =:accountId OR to_account =:accountId", nativeQuery = true)
    List<Transaction> getTransactionByAccount(@Param("accountId") int accountId);
}
