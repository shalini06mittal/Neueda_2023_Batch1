package com.boot.rest.SpringBootWebDemo.web01.dao;

import com.boot.rest.SpringBootWebDemo.web01.dto.CountrySales;
import com.boot.rest.SpringBootWebDemo.web01.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
@Repository

public class OrderDALMongoTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAllOrders() {
        return mongoTemplate.findAll(Order.class);
    }
    public Order getOrderById(String orderID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(orderID));
        return mongoTemplate.findOne(query, Order.class);
    }


    public List<CountrySales> getSalesForCountry() {

        GroupOperation groupByCountrySumSales = group("Country").sum("Revenue")
                .as("total_sales");

        MatchOperation allCountries = match(new Criteria("Country").exists(true));

        ProjectionOperation includes = project("total_sales").and("country").previousOperation();

        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"total_sales"));

        Aggregation aggregation = newAggregation(allCountries,groupByCountrySumSales,sortBySalesDesc,includes);
        AggregationResults<CountrySales> groupResults = mongoTemplate
                .aggregate(aggregation, "orders", CountrySales.class);
        List<CountrySales> result = groupResults.getMappedResults();
        return result;
    }



    public List<Order> getOrderName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customer").is(name));
        return mongoTemplate.find(query, Order.class);
    }
}
