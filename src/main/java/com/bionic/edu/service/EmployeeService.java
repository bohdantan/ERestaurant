package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entity.Employee;

public interface EmployeeService {
	Employee findById(int id);
	public List<Employee> findAll();
	boolean save(Employee employee);
	//void update(Employee employee);
	Employee signIn(String name, String password);
}
