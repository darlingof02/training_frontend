package com.kaseya.kaseyatraining.service;

import com.kaseya.beans.Employee;
import com.kaseya.dao.EmployeeDao;
import com.kaseya.dao.SkillLevelDao;
import com.kaseya.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Stubber;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {


    @Mock
    private SkillLevelDao skillLevelDao;
    @Mock
    private EmployeeDao employeeDao;
    @InjectMocks
    EmployeeService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllEmployees() {
        //when
        underTest.getAllEmployees();

        //then
        verify(employeeDao).findAll();
    }

    @Test
    void addNewEmployee() {
        //given
        Employee employee = new Employee("1");

        //when
        underTest.addNewEmployee(employee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor
                = ArgumentCaptor.forClass(Employee.class);
        verify(employeeDao).save(employeeArgumentCaptor.capture());
        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(employee);
    }

    @Test
    void updateAnEmployee() {
        //given
        Employee employee = new Employee("1");
        given(employeeDao.findAllByEmployeeID(employee.getEmployeeID()))
                .willReturn(employee);
        given(skillLevelDao.findById(employee.getSkillLevel().getSkillLevelID()))
                .willReturn(Optional.ofNullable(employee.getSkillLevel()));

        //when
        underTest.updateAnEmployee(employee, employee.getEmployeeID());

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor
                = ArgumentCaptor.forClass(Employee.class);
        verify(employeeDao).save(employeeArgumentCaptor.capture());
        Employee captorValue = employeeArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(employee);

    }

    @Test
    void removeAEmployee() {
        //given
        Employee employee = new Employee("1");

        //when
        underTest.removeAEmployee(employee.getEmployeeID());

        //then
        ArgumentCaptor<UUID> employeeArgumentCaptor
                = ArgumentCaptor.forClass(UUID.class);
        verify(employeeDao).removeEmployeeByEmployeeID(employeeArgumentCaptor.capture());
        UUID captorValue = employeeArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(employee.getEmployeeID());
    }
}