package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.EmployeeDao;
import com.bionic.edu.entity.Employee;

@Named
public class EmployeeServiceImpl implements EmployeeService {
	@Inject
	private EmployeeDao employeeDao;

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	@Transactional
	public boolean save(Employee employee) {
		if (employee.getId() != 0 || employeeDao.findByName(employee.getName()) == null) {
			employeeDao.save(employee);
			return true;
		} else {
			return false;
		}
	}
	
	/*@Transactional
	public void update(Employee employee) {
		employeeDao.update(employee);
	}*/
	
	public Employee signIn(String name, String password) {
		Employee e = employeeDao.findByName(name);
		if (e != null && password.equals(e.getPassword()) && e.isActivated()) {
			return e;
		} else {
			return null;
		}
	}
}
