package com.kaseya.controllers;

import com.kaseya.beans.Employee;
import com.kaseya.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Employee> getALLEmployees() {
        return employeeService.getAllEmployees();
    }

    //insert
    @PostMapping
    public UUID addANewEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        Employee employee1 = employeeService.addNewEmployee(employee);
        return employee1.getEmployeeID();
    }

    //update
    @PutMapping("/{id}")
    public Employee updateAnEmployee(@RequestBody Employee employee, @PathVariable UUID id) {
        return employeeService.updateAnEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public void deleteeEmployee(@PathVariable UUID id) {
        employeeService.removeAEmployee(id);
    }
}
