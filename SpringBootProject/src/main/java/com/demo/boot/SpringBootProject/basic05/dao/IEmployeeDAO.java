package com.demo.boot.SpringBootProject.basic05.dao;

import com.demo.boot.SpringBootProject.basic05.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long employeeId);
    Employee addNewEmployee(Employee employee);
}
