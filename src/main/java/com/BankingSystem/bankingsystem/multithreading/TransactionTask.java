package com.BankingSystem.bankingsystem.multithreading;

import com.BankingSystem.bankingsystem.service.TransactionService;
import com.BankingSystem.bankingsystem.exception.InvalidAccountException;
import com.BankingSystem.bankingsystem.exception.InsufficientBalanceException;

public class TransactionTask implements Runnable {

    private final TransactionService transactionService;
    private final String fromAccount;
    private final String toAccount;
    private final double amount;

    public TransactionTask(TransactionService transactionService, String fromAccount, String toAccount, double amount){
        this.transactionService = transactionService;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            transactionService.transfer(fromAccount, toAccount, amount);
            }catch (InvalidAccountException | InsufficientBalanceException e){
            System.err.println("Transaction failed [" + Thread.currentThread().getName() + "]" + e.getMessage());
        }catch (Exception e){
            System.err.println("Unexpected error [" + Thread.currentThread().getName() + e.getMessage());
        }
    }
}
