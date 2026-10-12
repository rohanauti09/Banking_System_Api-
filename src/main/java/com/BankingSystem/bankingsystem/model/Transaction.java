package com.BankingSystem.bankingsystem.model;

import java.time.LocalDateTime;

public class Transaction {

    //the fields....

    private String transactionId;
    private String fromAccount;
    private String toAccount;
    private double amount;
    private String transactionType;
    private LocalDateTime timestamp;

    //the constructors.....


    public Transaction(String transactionId, String fromAccount, String toAccount, double amount, String transactionType) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = LocalDateTime.now();
    }

    //getters......


    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
