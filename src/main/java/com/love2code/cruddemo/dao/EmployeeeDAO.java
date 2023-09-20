package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);


}
