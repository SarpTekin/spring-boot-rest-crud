package com.love2code.cruddemo.service;

import com.love2code.cruddemo.dao.EmployeeeDAO;
import com.love2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeeDAO employeeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeeDAO employeeeDAO) {
        this.employeeeDAO = employeeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeeDAO.findAll();
    }
}
