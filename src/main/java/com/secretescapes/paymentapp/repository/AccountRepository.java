package com.secretescapes.paymentapp.repository;

import com.secretescapes.paymentapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select * from accounts", nativeQuery = true)
    List<Account> getAllAccounts();

}
