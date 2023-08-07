package com.payment;

public class PaymentService {

    public double makePayment(double amount, double discount){
        amount = amount - amount * discount/100;
        double total = amount + 0.18;
        return  total;
    }


}