package com.neueda.boot.SpringBootDemo.exercise2.entity;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {

    private int txid;
    private String customerid;
    private String type;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(int txid, String customerid, String type, LocalDate date) {
        this.txid = txid;
        this.customerid = customerid;
        this.type = type;
        this.date = date;
    }

    public int getTxid() {
        return txid;
    }

    public void setTxid(int txid) {
        this.txid = txid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txid=" + txid +
                ", customerid='" + customerid + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
