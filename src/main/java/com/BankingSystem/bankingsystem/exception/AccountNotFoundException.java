package com.BankingSystem.bankingsystem.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message){
        super(message);
    }
}
