package com.boot.rest.SpringBootWebDemo.web01.controller;

import com.boot.rest.SpringBootWebDemo.web01.dto.CountrySales;
import com.boot.rest.SpringBootWebDemo.web01.entity.Order;
import com.boot.rest.SpringBootWebDemo.web01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id){
        return orderService.getOrderById(id);
    }
    @GetMapping
    public List<Order> getOrders()
    {
        return orderService.getAllOrders();
    }
    @GetMapping("/sales")
    public List<CountrySales> getCountrySales()
    {
        return orderService.getCountrySales();
    }
    @GetMapping("/year/{year}")
    public List<Order> getOrdersByYear(@PathVariable int year)
    {
        return orderService.getOrderByYear(year);
    }
    @GetMapping("/year/{year}/revenue/{revenue}")
    public List<Order> getOrdersByYear(@PathVariable int year,
                                       @PathVariable double revenue)
    {
        return orderService.getOrderByYearRevenueSort(year, revenue);
    }
}
