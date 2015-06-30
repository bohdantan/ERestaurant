package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Employee;
import com.bionic.edu.service.EmployeeService;

@Named
@Scope("session")
public class EmployeeListBean {
	@Inject
	private EmployeeService employeeService;
	
	private List<Employee> employeeList = null;
	private Employee employee;
	private java.util.Date employeeBirthDate;

	public java.util.Date getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(java.util.Date employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void refreshList() {
		employeeList = employeeService.findAll();
	}

	public String saveEmployee() {
		if (employeeBirthDate != null) {
			employee.setBirthDate(new java.sql.Date(employeeBirthDate.getTime()));
		}
		employeeBirthDate = null;
		employeeService.save(employee);
		return "EmployeeList";
	}

	public String addEmployee() {
		employee = new Employee();
		return "newEmployee";
	}

	public String editEmployee(String id) {
		employee = employeeService.findById(Integer.valueOf(id));
		return "newEmployee";
	}
}
