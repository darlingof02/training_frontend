package com.kaseya.controller;

import com.kaseya.controllers.EmployeeController;
import com.kaseya.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployControllerTest {


    @Mock
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    @BeforeEach void setUp() {
        this.employeeController = new EmployeeController();
    }

}
