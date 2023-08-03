package com.neueda.boot.SpringBootDemo.exercise2.service;

import com.neueda.boot.SpringBootDemo.exercise2.entity.Transaction;
import com.neueda.boot.SpringBootDemo.exercise2.exception.NoTransactionsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransactionService {

    @Autowired
    private List<Transaction>  transactions;
    public List<Transaction> getTransactions(String customerid) {
        return transactions.stream()
                .filter((transaction) -> transaction.getCustomerid().equals(customerid))
                .collect(Collectors.toList());
    }
    public List<Transaction> getTransactionsByType(String customerid, String type) {
        return transactions.stream()
                .filter((transaction) -> transaction.getCustomerid().equals(customerid) && transaction.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsElseThrowException(String customerid) throws NoTransactionsFoundException {
//        return transactions.stream()
//                .filter((transaction) -> transaction.getCustomerid().equals(customerid))
//                .collect(Collectors.toList());
        List<Transaction> transactionsById = new ArrayList<>();
        for(Transaction transaction : transactions)
            if(transaction.getCustomerid().equals(customerid))
                transactionsById.add(transaction);
        if(transactionsById.size()>0)
            return transactionsById;
        throw new NoTransactionsFoundException("No transactions exist for the customer with id "+customerid);

    }
}
