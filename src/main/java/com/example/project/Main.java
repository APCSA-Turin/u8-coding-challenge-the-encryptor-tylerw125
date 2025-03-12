package com.example.project;

public class Main {
    public static void main(String[] args) {
        String encrypt1 = "This is a test of the encryption on this message";
        System.out.println(Encryptor.encryptMessage(encrypt1, 4));

    }
}
