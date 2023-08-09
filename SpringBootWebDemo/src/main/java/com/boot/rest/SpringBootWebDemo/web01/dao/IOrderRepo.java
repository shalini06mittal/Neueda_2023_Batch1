package com.boot.rest.SpringBootWebDemo.web01.dao;



import com.boot.rest.SpringBootWebDemo.web01.entity.Order;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderRepo extends MongoRepository<Order,String> {
//db.orders.find({'$group':{_id:'$Country', total:{$sum:'$'}}).pretty()
//    @Aggregation(pipeline = {
//            "{$group:{_id:'$country',total:{$sum:'$sales'}}}"
//    })
//    public List<Order> getCountrySales();

    /**
     * $match - Filters documents based on whether their field matches a given predicate.
     * $count - Returns the count of the documents left in the pipeline.
     * $limit - Limits the number of (slices) returned documents, starting at the beginning of the set and approaching the limit.
     * $sample - Randomly samples a given number of documents from a set.
     * $sort - Sorts the documents given a field and sorting order.
     * $merge - Writes the documents in the pipeline into a collection.
     */
    @Aggregation(pipeline ={
            "{'$match':{'Year':?0, 'Revenue':{$gt:1000}}}"
    })
    public List<Order> getAllOrderByYear(int year);

    @Aggregation(pipeline = {
            "{'$match':{'Year':?0, 'Revenue': {$gt: ?1} }}",
            "{'$sample':{size:10}}",
            "{'$sort':{'Quantity':-1}}"
    })
    List<Order> findOrderByYearGreaterThanRevenueAndSort(int year, double revenue);

}
