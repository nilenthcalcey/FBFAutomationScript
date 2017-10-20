package com.fbf.automation.utils;

import java.util.List;

/**
 * Custom logger class
 */
public class Logger {
    public static void log(String logMessage) {
        System.out.println(logMessage);
    }

    public static void log(List<String> logMessages) {
        String message = "";
        for(String logMessage : logMessages) {
            message += logMessage;
        }

        log(message);
    }

}

