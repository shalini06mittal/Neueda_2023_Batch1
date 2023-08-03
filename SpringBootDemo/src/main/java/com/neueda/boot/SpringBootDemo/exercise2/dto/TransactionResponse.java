package com.neueda.boot.SpringBootDemo.exercise2.dto;

import com.neueda.boot.SpringBootDemo.exercise2.entity.Transaction;

import java.util.List;

public class TransactionResponse {
    String message;
    List<Transaction> transactionList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "message='" + message + '\'' +
                ", transaction List=" + transactionList +
                '}';
    }
}
