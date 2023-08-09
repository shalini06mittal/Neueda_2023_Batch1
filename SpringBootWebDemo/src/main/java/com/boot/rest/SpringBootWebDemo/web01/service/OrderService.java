package com.boot.rest.SpringBootWebDemo.web01.service;

import com.boot.rest.SpringBootWebDemo.web01.dto.CountrySales;
import com.boot.rest.SpringBootWebDemo.web01.entity.Order;
import com.boot.rest.SpringBootWebDemo.web01.dao.IOrderRepo;
import com.boot.rest.SpringBootWebDemo.web01.dao.OrderDALMongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrderRepo repo;

    @Autowired
    private OrderDALMongoTemplate dao;

    public List<CountrySales> getCountrySales(){
        return dao.getSalesForCountry();
    }
    public List<Order> getAllOrders(){
        return  repo.findAll(); }

    public Order getOrderById(String id){
        return repo.findById(id).get();
    }

    public List<Order> getOrderByYear(int year){
        return repo.getAllOrderByYear(year);
    }

    public List<Order> getOrderByYearRevenueSort(int year, double revenue){
        return repo.findOrderByYearGreaterThanRevenueAndSort(year, revenue);
    }



}
