package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements  EmployeeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee ", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);

    }
}
