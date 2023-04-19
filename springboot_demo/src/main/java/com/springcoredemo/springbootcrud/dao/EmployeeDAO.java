package com.springcoredemo.springbootcrud.dao;

import java.util.List;

import com.springcoredemo.springbootcrud.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
