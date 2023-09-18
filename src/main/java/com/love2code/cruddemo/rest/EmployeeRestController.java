package com.love2code.cruddemo.rest;


import com.love2code.cruddemo.entity.Employee;
import com.love2code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeeService;

    public EmployeeRestController(EmployeeService theEmployeeeService) {
        employeeeService = theEmployeeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeeService.findAll();
    }


}
