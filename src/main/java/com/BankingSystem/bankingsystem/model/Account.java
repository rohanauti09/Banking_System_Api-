package com.BankingSystem.bankingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "user_id", nullable = false)
    private String userId;

    private String accountType;

    private double balance;

    public Account() {}

    public Account(String accountNumber, String userId, String accountType) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    // getters & setters
    public int getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public String getUserId() { return userId; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
