package com.neueda.boot.SpringBootDemo.exercise2.exception;

public class NoTransactionsFoundException extends Exception{

    public NoTransactionsFoundException(String message)
    {
        super(message);
    }
}
