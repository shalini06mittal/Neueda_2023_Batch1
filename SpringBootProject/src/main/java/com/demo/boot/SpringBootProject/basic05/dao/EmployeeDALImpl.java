package com.demo.boot.SpringBootProject.basic05.dao;


import com.demo.boot.SpringBootProject.basic05.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDALImpl implements  IEmployeeDAO{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        return  mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        return mongoTemplate.findOne(query, Employee.class);
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        mongoTemplate.save(employee);
        // Now, user object will contain the ID as well
        return employee;
    }
}
