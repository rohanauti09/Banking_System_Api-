package com.BankingSystem.bankingsystem.exception;

public class InvalidAccountException extends RuntimeException{

    public InvalidAccountException(String message){
        super(message);
    }
}
