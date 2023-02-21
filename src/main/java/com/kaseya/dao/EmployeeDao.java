package com.kaseya.dao;

import com.kaseya.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, UUID> {
    List<Employee> findAll();

    Employee findAllByEmployeeID(UUID id);

    @Transactional
    void removeEmployeeByEmployeeID(UUID id);
}
