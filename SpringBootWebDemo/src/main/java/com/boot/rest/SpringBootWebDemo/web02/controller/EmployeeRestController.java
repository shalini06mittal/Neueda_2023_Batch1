package com.boot.rest.SpringBootWebDemo.web02.controller;

import com.boot.rest.SpringBootWebDemo.web02.dto.EmployeePerPageResponse;
import com.boot.rest.SpringBootWebDemo.web02.entity.Employee;
import com.boot.rest.SpringBootWebDemo.web02.exception.RecordExistsException;
import com.boot.rest.SpringBootWebDemo.web02.exception.RecordNotFoundException;
import com.boot.rest.SpringBootWebDemo.web02.service.EmployeeService;
import com.boot.rest.SpringBootWebDemo.web02.utility.StatusMessages;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@Tag(name="EMPLOYEE-CONTROLLER")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(required = false) String region)
    {
        if(region == null)
        return employeeService.getAllEmployees();
        return employeeService.getAllEmployeesByRegion(region);
    }

    /**
     * Path variable is used to map the value passed in the path of url
     * http://localhost:8080/employees/10 => so 10 is mapped with employeeId
     * @param employeeId
     * @return
     */
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId)
    {
        try {
            return this.employeeService.getEmployeeById(employeeId);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/resp/{employeeId}")
    public ResponseEntity<Object> getEmployeeByIdResponse(@PathVariable long employeeId)
    {
        try {
            Employee employee = this.employeeService.getEmployeeById(employeeId);
            return ResponseEntity.status(HttpStatus.FOUND).body(employee);
        } catch (RecordNotFoundException e) {
           // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        try {
            Employee employee1 = this.employeeService.insertEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
        } catch (RecordExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee)
    {
        Map<StatusMessages , String> map = new HashMap<>();
        try {
            this.employeeService.updateEmployee(employee);
            map.put(StatusMessages.SUCCESS, "Employee updated successfully");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable long employeeId)
    {
        Map<StatusMessages , String> map = new HashMap<>();
        try {
            map.put(StatusMessages.SUCCESS, "Employee deleted successfully");
            this.employeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }
    @GetMapping("/pages")
    public EmployeePerPageResponse getEmployeesByPage(@RequestParam(required = false, defaultValue = "0") int pageno,
                                                      @RequestParam(required = false, defaultValue = "5") int size)
    {
        return this.employeeService.getEmployeesByPagination(pageno, size);
    }

}
