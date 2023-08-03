package com.demo.boot.SpringBootProject.basic05.service;

import java.util.List;

import com.demo.boot.SpringBootProject.basic05.dao.EmployeeRepository;
import com.demo.boot.SpringBootProject.basic05.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Insert an employee.
    public void addEmployee()
    {
        Employee newEmp = new Employee(-1, "Simon Peter", 10000, "Israel");
        Employee employee = repository.save(newEmp);
        System.out.printf("There are now %d employees\n", repository.count());
    }
    // Get all employees.
    public void getAllEmployees()
    {
        displayEmployees("All employees list ", repository.findAll());
    }

    // Get all employees by region.
    public void getAllEmployeesByRegion(String region) {
        displayEmployees("All employees By Region: ", repository.findEmployeesByRegion(region));
    }
    // Get all employees by salary range.
    public void getAllEmployeesByRange(double from, double to) {
        List<Employee> emps = repository.findEmployeesInSalaryRange(from,  to);
        displayEmployees("Employees earning 20k to 50k: ", emps);
    }
    // Get a page of employees.
    public void getEmployeesByPagination(double from, double to) {
        Pageable pageable = PageRequest.of(1, 3, Direction.DESC, "dosh");
        Page<Employee> page = repository.findEmployeesByDoshGreaterThan(50000, pageable);
        displayEmployees("Page 1 of employees more than 50k: ", page.getContent());

        pageable = PageRequest.of(1, 3);
        page = repository.findAll( pageable);
        System.out.println(page.getTotalPages());
        displayEmployees("Page 1 of all employees ", page.getContent());
    }

    public void updateEmployee( Employee empToUpdate)
    {
       if(repository.existsById(empToUpdate.getEmployeeId())){
           repository.save(empToUpdate);
       }
       else
           System.out.println("Employee not found");
    }
    public void deleteEmployee(long employeeId)
    {
        Employee employee = repository.findById(employeeId).orElse(null);
        if(employee != null){
            repository.save(employee);
        }
        else
            System.out.println("Employee not found");
    }
    private void displayEmployees(String message, Iterable<Employee> employees) {
        System.out.printf("\n%s\n", message);
        for (Employee emp: employees) {
            System.out.println(emp);
        }
    }

}