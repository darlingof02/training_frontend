package com.kaseya.kaseyatraining.controllers;

import com.kaseya.beans.Employee;
import com.kaseya.controllers.EmployeeController;
import com.kaseya.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getALLEmployees() {
        //given

        //when
        underTest.getALLEmployees();

        //then
        verify(employeeService).getAllEmployees();
    }

    @Test
    void addANewEmployee() {
        //given
        Employee employee = new Employee("1");
        given(employeeService.addNewEmployee(employee))
                .willReturn(employee);

        //when
        underTest.addANewEmployee(employee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor
                = ArgumentCaptor.forClass(Employee.class);
        verify(employeeService).addNewEmployee(employeeArgumentCaptor.capture());
        Employee captorValue = employeeArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(employee);
    }

    @Test
    void updateAnEmployee() {
        //given
        Employee employee = new Employee("1");
        //when
        underTest.updateAnEmployee(employee, employee.getEmployeeID());
        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor
                = ArgumentCaptor.forClass(Employee.class);
        ArgumentCaptor<UUID> uuidArgumentCaptor
                = ArgumentCaptor.forClass(UUID.class);
        verify(employeeService).updateAnEmployee(employeeArgumentCaptor.capture(), uuidArgumentCaptor.capture());
        Employee employeeArgumentCaptorValue = employeeArgumentCaptor.getValue();
        UUID uuidArgumentCaptorValue = uuidArgumentCaptor.getValue();
        assertThat(employeeArgumentCaptorValue).isEqualTo(employee);
        assertThat(uuidArgumentCaptorValue).isEqualTo(employee.getEmployeeID());
    }

    @Test
    void deleteEmployee() {
        //given
        Employee employee = new Employee("1");
        //when
        underTest.deleteEmployee(employee.getEmployeeID());
        //then
        ArgumentCaptor<UUID> uuidArgumentCaptor
                = ArgumentCaptor.forClass(UUID.class);
        verify(employeeService).removeAEmployee(uuidArgumentCaptor.capture());
        UUID uuidArgumentCaptorValue = uuidArgumentCaptor.getValue();
        assertThat(uuidArgumentCaptorValue).isEqualTo(employee.getEmployeeID());
    }
}