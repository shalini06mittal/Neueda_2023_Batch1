package com.demo.boot.SpringBootProject.basic05.dao;

import java.util.List;

import com.demo.boot.SpringBootProject.basic05.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EmployeeRepository extends MongoRepository<Employee,Long> {

//    @Query("{region:'?0'}")
//    List<Employee> seekByRegion(String region);

    List<Employee> findEmployeesByRegion(String region);
    @Query("{'dosh' : {$gte : ?0, $lte : ?1}}")
    List<Employee> findEmployeesInSalaryRange(double from, double to);

    Page<Employee> findEmployeesByDoshGreaterThan(double salary, Pageable pageable);
}
