package com.love2code.cruddemo.service;

import com.love2code.cruddemo.dao.EmployeeeDAO;
import com.love2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Employee findById(int theId) {
        return employeeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeeDAO.deleteById(theId);
    }
}
