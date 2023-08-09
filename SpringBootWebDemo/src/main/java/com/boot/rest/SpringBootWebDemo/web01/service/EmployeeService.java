package com.boot.rest.SpringBootWebDemo.web01.service;

import java.util.List;

import com.boot.rest.SpringBootWebDemo.web01.dao.EmployeeRepository;
import com.boot.rest.SpringBootWebDemo.web01.dto.EmployeePerPageResponse;
import com.boot.rest.SpringBootWebDemo.web01.entity.Employee;
import com.boot.rest.SpringBootWebDemo.web01.exception.RecordExistsException;
import com.boot.rest.SpringBootWebDemo.web01.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    // Insert an employee.
    public Employee insertEmployee(Employee employee) throws RecordExistsException {
        if(repository.existsById(employee.getEmployeeId()))
            throw new RecordExistsException("Employee with "+employee.getEmployeeId()+"already exists");
        long count = this.repository.count();
        employee.setEmployeeId(count+1);
        Employee savedEmployee = repository.save(employee);
        System.out.printf("There are now %d employees\n", repository.count());
        return  savedEmployee;
    }
    // Get all employees.
    public List<Employee> getAllEmployees()
    {
        return this.repository.findAll();
    }
    public Employee getEmployeeById(long empid) throws RecordNotFoundException {
           return repository.findById(empid)
                    .orElseThrow(()->new RecordNotFoundException("employee with "+empid+" does not exist"));
    }
    // Get all employees by region.
    public List<Employee> getAllEmployeesByRegion(String region) {
        return this.repository.findEmployeesByRegion(region);
    }
    // Get all employees by salary range.
    public List<Employee> getAllEmployeessalaryRangen(double from , double to) {
        return this.repository.findEmployeesInSalaryRange(from, to);
    }
    // Get a page of employees.
    public EmployeePerPageResponse getEmployeesByPagination(int pageno, int size) {
        Pageable pageable = PageRequest.of(pageno, size);
        Page<Employee> page = repository.findAll( pageable);
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int noofelements = page.getNumberOfElements();
        int pagesize = page.getSize();
        EmployeePerPageResponse response = new EmployeePerPageResponse();
        response.setEmployees(page.getContent());
        response.setNoofelements(noofelements);
        response.setPagesize(pagesize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        return response;
    }

    public void updateEmployee( Employee empToUpdate) throws RecordNotFoundException {
        System.out.println("UPDATE "+empToUpdate.getEmployeeId());
       if(! repository.existsById(empToUpdate.getEmployeeId()))
           throw new RecordNotFoundException("employee with "+empToUpdate.getEmployeeId()+" does not exist");
       repository.save(empToUpdate);
    }
    public void deleteEmployee(long employeeId) throws RecordNotFoundException {

        if(repository.existsById(employeeId))
            throw new RecordNotFoundException("employee with "+employeeId+" does not exist");
        repository.deleteById(employeeId);
    }
}