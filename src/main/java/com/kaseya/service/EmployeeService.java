package com.kaseya.service;

import com.kaseya.beans.Employee;
import com.kaseya.beans.SkillLevel;
import com.kaseya.dao.EmployeeDao;
import com.kaseya.dao.SkillLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    SkillLevelDao skillLevelDao;

    public List<Employee> getAllEmployees() {

        return employeeDao.findAll();
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public Employee updateAnEmployee(Employee employee, UUID id) {
//        employeeDao.removeEmployeeByEmployeeID(id);
//        employee.setEmployeeID(id);
        Employee employee1 = employeeDao.findAllByEmployeeID(id);
        employee1.setActive(employee.isActive());
        employee1.setAge(employee.getAge());
        employee1.setDOB(employee.getDOB());
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        SkillLevel skillLevel1 = skillLevelDao.findById(employee.getSkillLevel().getSkillLevelID()).get();
        employee1.setSkillLevel(skillLevel1);
        System.out.println(employee1);
        return employeeDao.save(employee1);
    }

    public void removeAEmployee(UUID id) {
        employeeDao.removeEmployeeByEmployeeID(id);
    }

}
