package com.kaseya.kaseyatraining.dao;

import com.kaseya.beans.Employee;
import com.kaseya.dao.EmployeeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeDaoTest {

    @Autowired
    private EmployeeDao underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void checkIfFindAllCorrect() {
        //given
        Employee employee1 = new Employee("1", null);
        Employee employee2 = new Employee("2", null);
        Employee employee3 = new Employee("3", null);
        underTest.save(employee1);
        underTest.save(employee2);
        underTest.save(employee3);
        List<Employee> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee3);

        //when
        List<Employee> testResults = underTest.findAll();

        //then
        assertThat(testResults).isEqualTo(expected);
    }

    @Test
    void checkIfFindAllByEmployeeIDWork() {
       //given
        Employee employee = new Employee("1", null);
        underTest.save(employee);
        List<Employee> ls = underTest.findAll();
        Employee expected = ls.get(0);
        UUID id = expected.getEmployeeID();

       //when
        Employee testResult = underTest.findAllByEmployeeID(id);

       //then
        assertThat(testResult).isEqualTo(expected);
    }

    @Test
    void checkIfRemoveEmployeeByEmployeeIDWork() {
        //given
        Employee employee = new Employee("1", null);
        underTest.save(employee);
        List<Employee> ls = underTest.findAll();
        UUID id = ls.get(0).getEmployeeID();

        //when
        underTest.removeEmployeeByEmployeeID(id);
        List<Employee> testResult = underTest.findAll();

        //then
        assertThat(testResult).isEqualTo(new ArrayList<>());
    }
}