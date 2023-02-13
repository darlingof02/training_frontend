package com.kaseya.controllers;

import com.kaseya.beans.Employee;
import com.kaseya.service.EmployeeService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    EmployeeController@GetMapping
//    public String testEmployee() {
//        return "hello new user";
//    }

    @Autowired
    EmployeeService employeeService;
    @GetMapping
    @Cacheable(value = "employees")
    public List<Employee> getALLEmployees() {
        return employeeService.getAllEmployees();
    }

    //insert
    @PostMapping
    @CacheEvict(value = "employees", allEntries = true)
    public UUID addANewEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        Employee employee1 = employeeService.addNewEmployee(employee);
        return employee1.getEmployeeID();
    }

    //update
    @PutMapping("/{id}")
    @CacheEvict(value = "employees", allEntries = true)
    public Employee updateAnEmployee(@RequestBody Employee employee, @PathVariable UUID id) {
        return employeeService.updateAnEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteeEmployee(@PathVariable UUID id) {
        employeeService.removeAEmployee(id);
    }
}
