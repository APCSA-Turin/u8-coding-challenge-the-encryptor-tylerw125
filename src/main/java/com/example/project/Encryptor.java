package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0) { return 1; }
        int numCols = 0;
        if (messageLen % rows != 0) {
            numCols = (messageLen / rows) + 1;
        } else {
            numCols = messageLen / rows;
        }
        return numCols;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int cols = determineColumns(message.length(), rows);
        String[][] grid = new String[rows][cols];
        int ind = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ind < message.length()) {
                    grid[i][j] = String.valueOf(message.charAt(ind));
                    ind++;
                } else {
                    grid[i][j] = "=";
                }
            }
        }
        return grid;
    }

    public static String encryptMessage(String message, int rows) {
        if (message.isEmpty()) {
            return "=".repeat(rows);
        }
        String [][] grid = generateEncryptArray(message, rows);
        int cols = grid[0].length;
        StringBuilder encrypt = new StringBuilder();

        for (int j = cols - 1; j >= 0; j--) {
            for (int i  = 0; i < rows; i++) {
                encrypt.append(grid[i][j]);
            }
        }
        return encrypt.toString();
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        if (encryptedMessage.isEmpty()) {
            return "";
        }

        int cols = determineColumns(encryptedMessage.length(), rows);
        if (rows * cols != encryptedMessage.length()) {
            return "";
        }
        String[][] grid = new String[rows][cols];
        int ind = 0;

        for (int j = cols - 1; j >= 0 ; j--) {
            for ( int i = 0; i < rows; i++) {
                grid[i][j] = String.valueOf(encryptedMessage.charAt(ind));
                ind++;
            }
        }

        StringBuilder decrypt = new StringBuilder();
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) {
                if (!grid[i][j].equals("=")) { 
                    decrypt.append(grid[i][j]);
                }
            }
        }
        return decrypt.toString();
    }
}