package com.boot.rest.SpringBootWebDemo.web01.controller;

import com.boot.rest.SpringBootWebDemo.web01.dto.EmployeePerPageResponse;
import com.boot.rest.SpringBootWebDemo.web01.entity.Employee;
import com.boot.rest.SpringBootWebDemo.web01.exception.RecordExistsException;
import com.boot.rest.SpringBootWebDemo.web01.exception.RecordNotFoundException;
import com.boot.rest.SpringBootWebDemo.web01.service.EmployeeService;
import com.boot.rest.SpringBootWebDemo.web01.utility.StatusMessages;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * If using @Controller then to create REST API's you need to add @ResponseBody on the methods
 * to return data as a response
 */

/**
 * Ideally there should not be separate paths for respective HTTP methods. The REST URI should not contain verbs in them.
 * Hence if path is http://localhhost:8080/employees,
 * then for the verbs/HTTP methods use respective GET/POST/PUT/DELETE annotations
 */
//@Controller // If using @Controller then @ResponseBody is used to create REST API
@RestController
/**
 * If the /employees is common across the mappings then there can be 1 root mapping as follows:
 * Remove the /employees mappings from other annotations
 */
@RequestMapping("/employees")
// @Tag is used to display name on swagger UI, ONLY IF SWAGGER ADDED AS DEPENDENCY
@Tag(name="EMPLOYEE-CONTROLLER")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    /**
     * @RequestMapping is a general annotation. To restrict access for different HTTP methods,
     * need to add method attribute separately
     * Instead use more composed annotations [@GetMapping, @PostMapping, @PutMapping, @DeleteMapping]
     * for all HTTP methods
     */
    //@RequestMapping("/employees/get")
    //@RequestMapping(path = "/employees/get",, method = RequestMethod.GET)
    //@GetMapping("/employees/get")
    /**
     * Just use annotations for respective HTTP methods and no need to put verbs within them
     * @return
     */
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
    //@RequestMapping("/employees/post")
   // @RequestMapping(path = "/employees/post", method = RequestMethod.POST)
    //@PostMapping("/employees/post")
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

    @GetMapping("/from/{from}/to/{to}")
    public List<Employee> getAllEmployeesInSalaryRange(
            @PathVariable double from, @PathVariable double to) {

        return employeeService.getAllEmployeessalaryRangen(from, to);
    }

}
