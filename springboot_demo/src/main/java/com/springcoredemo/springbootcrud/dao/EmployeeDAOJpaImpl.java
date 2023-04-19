package com.springcoredemo.springbootcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcoredemo.springbootcrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up construction injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() 
	{
		//create a query 
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList(); 
		//return the results
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
	public void deleteById(int theId) 
	{
		Employee theEmployee = entityManager.find(Employee.class, theId);
		entityManager.remove(theEmployee);
		
	}

}
