package com.BankingSystem.bankingsystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String LOG_FILE = "banking_app.log";

    public static synchronized void log(String message){
        try(FileWriter writer=new FileWriter(LOG_FILE, true)){
            writer.write(LocalDateTime.now() + " : " + message + System.lineSeparator());
        }
        catch (IOException e){
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}
