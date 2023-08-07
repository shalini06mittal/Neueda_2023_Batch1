package com.boot.rest.SpringBootWebDemo.web01.dto;

import com.boot.rest.SpringBootWebDemo.web01.entity.Employee;

import java.util.List;

public class EmployeePerPageResponse {

    int totalPages;
    long totalElements;
    int noofelements ;
    int pagesize ;
    List<Employee> employees;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNoofelements() {
        return noofelements;
    }

    public void setNoofelements(int noofelements) {
        this.noofelements = noofelements;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
