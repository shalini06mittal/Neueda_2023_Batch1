package com.neueda.boot.SpringBootDemo.exercise2.controller;

import com.neueda.boot.SpringBootDemo.exercise2.dto.TransactionResponse;
import com.neueda.boot.SpringBootDemo.exercise2.entity.Transaction;
import com.neueda.boot.SpringBootDemo.exercise2.exception.NoTransactionsFoundException;
import com.neueda.boot.SpringBootDemo.exercise2.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    public List<Transaction> getTransactionsByCustomer(String customerid, String type)
    {
        switch (type){
            case "all":
                return transactionService.getTransactions(customerid);
            default:
                return transactionService.getTransactionsByType(customerid,type);
        }

    }

    public TransactionResponse getTransactionsByCustomerThrowException(String customerid)
    {
        TransactionResponse response = new TransactionResponse();
        try {
            List<Transaction> tx = transactionService.getTransactionsElseThrowException(customerid);
            response.setTransactionList(tx);
            response.setMessage("SUCCESS");

        } catch (NoTransactionsFoundException e) {
            response.setMessage(e.getMessage());
        }
        return  response;
    }
}
