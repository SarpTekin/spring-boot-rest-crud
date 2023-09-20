package com.love2code.cruddemo.rest;


import com.love2code.cruddemo.entity.Employee;
import com.love2code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeeService.findById(employeeId);

        if (theEmployee == null) {
            throw  new RuntimeException("Employee id not found - " + employeeId);
        }
        return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        Employee dbEmployee = employeeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tmpEmployee = employeeeService.findById(employeeId);

        if (tmpEmployee == null) {
            throw new RuntimeException("Empolee id not found - " + employeeId);
        }

        employeeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;

    }


}
