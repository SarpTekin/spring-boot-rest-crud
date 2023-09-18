package com.love2code.cruddemo.rest;


import com.love2code.cruddemo.dao.EmployeeeDAO;
import com.love2code.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeeDAO employeeeDAO;

    public EmployeeRestController(EmployeeeDAO theEmployeeDAO) {
        employeeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeeDAO.findAll();
    }


}
