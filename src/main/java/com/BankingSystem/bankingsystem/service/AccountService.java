package com.BankingSystem.bankingsystem.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BankingSystem.bankingsystem.model.Account;
import com.BankingSystem.bankingsystem.repository.AccountRepository;
import com.BankingSystem.bankingsystem.repository.UserRepository;
import com.BankingSystem.bankingsystem.util.IdGenerator;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository,
                          UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    
    //account creating method
    public Account createAccount(String userId, String accountType) {

        if (!userRepository.existsByUserId(userId)) {
            throw new RuntimeException("User does not exist: " + userId);
        }

        String accountNumber = IdGenerator.generateAccountNumber();

        Account account = new Account(accountNumber, userId, accountType);

        return accountRepository.save(account);
    }
    
    //deposit method

    @CachePut(value = "accounts", key = "#accountNumber")
    public double deposit(String accountNumber, double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new RuntimeException("Account not found: " + accountNumber);
        }

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        return account.getBalance(); // IMPORTANT: return cached value
    }

    //withdraw method

    @CachePut(value = "accounts", key = "#accountNumber")
    public double withdraw(String accountNumber, double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Withdraw amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new RuntimeException("Account not found: " + accountNumber);
        }

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);

        return account.getBalance();
    }

    @Caching(evict = {
            @CacheEvict(value = "accounts", key = "#fromAccountNumber"),
            @CacheEvict(value = "accounts", key = "#toAccountNumber")
    }) @Transactional
    public void transfer(String fromAccountNumber,
                         String toAccountNumber,
                         double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Transfer amount must be positive");
        }

        Account fromAccount =
                accountRepository.findByAccountNumber(fromAccountNumber);

        Account toAccount =
                accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            throw new RuntimeException("One or both accounts not found");
        }

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in source account");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
    
	//get balance method
    @Cacheable(value = "accounts", key = "#accountNumber")
	  public double getBalance(String accountNumber) {

        System.out.println("Fetching from DB...");
		    Account account = accountRepository.findByAccountNumber(accountNumber);
	
		    if (account == null) {
		        throw new RuntimeException("Account not found: " + accountNumber);
		    }
	
		    return account.getBalance();
		}

}
