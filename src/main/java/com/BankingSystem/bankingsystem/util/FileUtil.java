package com.BankingSystem.bankingsystem.util;

import com.BankingSystem.bankingsystem.model.Account;
import com.BankingSystem.bankingsystem.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    //the fields.....

    private static final String ACCOUNT_FILE = "accounts.txt";
    private static final String TRANSACTION_FILE = "transactions.txt";

    //save account to file....

    public static synchronized void saveAccount(Account account){
        try (FileWriter writer = new FileWriter(ACCOUNT_FILE, true)) {
            writer.write(account.toString());
            writer.write(System.lineSeparator());
        }
        catch (IOException e){
            LoggerUtil.log("Failed to save account: " + e.getMessage());
        }
    }

    //save transaction to the file.....

    public static synchronized void saveTransaction(Transaction transaction){
        try (FileWriter writer = new FileWriter(TRANSACTION_FILE, true)){
            writer.write(transaction.toString());
            writer.write(System.lineSeparator());
        }catch (IOException e){
            LoggerUtil.log("Failed to save transaction: " + e.getMessage());
        }
    }
    //read all accounts (for future extension)....

    public static List<String> readAccounts(){
        List<String> accounts = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE))){
            String line;
            while((line = reader.readLine()) != null){
                accounts.add(line);
            }
        }catch (IOException e){
            LoggerUtil.log("Failed to read accounts: " + e.getMessage());
        }
        return accounts;
    }
}
