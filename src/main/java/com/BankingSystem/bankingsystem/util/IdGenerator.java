package com.BankingSystem.bankingsystem.util;

import java.util.UUID;

public class IdGenerator {

    public static String generateUserId() {
        return "U-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateTransactionId() {
        return "TXN-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
