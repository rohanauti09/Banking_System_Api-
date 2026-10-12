package com.BankingSystem.bankingsystem.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final AccountService accountService;

    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }

    // TRANSFER MONEY (delegates to AccountService)
    public void transfer(String fromAccount, String toAccount, double amount) {

        if (fromAccount == null || toAccount == null) {
            throw new RuntimeException("Account numbers cannot be null");
        }

        if (fromAccount.equals(toAccount)) {
            throw new RuntimeException("Cannot transfer to the same account");
        }

        if (amount <= 0) {
            throw new RuntimeException("Transfer amount must be positive");
        }

        // Delegate to AccountService (handles DB + cache + transaction)
        accountService.transfer(fromAccount, toAccount, amount);
    }
}