package com.example.demo.core.exception.credit_card;

public class NoAvailableAmountException extends Exception{

    public NoAvailableAmountException(String message) {
        super(message);
    }
}
