package com.BankingSystem.bankingsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.BankingSystem.bankingsystem.model.Account;
import com.BankingSystem.bankingsystem.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // MENU OPTION: Create Account
    @PostMapping
    public Account createAccount(@RequestParam String userId,
                                 @RequestParam String accountType) {

        return accountService.createAccount(userId, accountType);
    }
    // MENU OPTION: Deposit Money
    @PutMapping("/deposit")
    public Account deposit(@RequestParam String accountNumber,
                           @RequestParam double amount) {

        return accountService.deposit(accountNumber, amount);
    }
    
    //MENU OPTION: Withdraw Money
    @PutMapping("/withdraw")
    public Account withdraw(@RequestParam String accountNumber,
                             @RequestParam double amount) {

        return accountService.withdraw(accountNumber, amount);
    }
    
   //MENU OPTION: Transfer Money
    @PutMapping("/transfer")
    public String transfer(@RequestParam String fromAccount,
                            @RequestParam String toAccount,
                            @RequestParam double amount) {

        accountService.transfer(fromAccount, toAccount, amount);
        return "Transfer successful";
    }
    
   //MENU OPTION: Check Balance
	@GetMapping("/balance")
	public double checkBalance(@RequestParam String accountNumber) {
	
	    return accountService.getBalance(accountNumber);
	}
}
