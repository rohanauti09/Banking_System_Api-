package com.BankingSystem.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BankingSystem.bankingsystem.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByAccountNumber(String accountNumber);
}
