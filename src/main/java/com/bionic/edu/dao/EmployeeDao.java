package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.Employee;

public interface EmployeeDao {
	Employee findById(int id);
	Employee findByName(String name);
	public List<Employee> findAll();
	void save(Employee employee);
	//void update(Employee employee);
}
