package com.bionic.edu.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Employee;
import com.bionic.edu.service.EmployeeService;


@Named
@Scope("session")
public class EmployeeBean {
	@Inject
	private EmployeeService employeeService;
	
	private boolean signedIn;
	private Employee employee;
	private String status = "";
	
	public boolean isSignedIn() {
		return signedIn;
	}
	
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void startSignIn() {
		employee = new Employee();
	}
	
	public String finishSignIn() {
		employee = employeeService.signIn(employee.getName(), employee.getPassword());
		if (employee == null) {
			status = "Bad login or password";
			return "EmployeeSignIn";
		}
		signedIn = true;
		if (employee.isSequrityOfficer()) {
			return "EmployeeList";
		} else if (employee.isAdministrator()) {
			return "FoodList";
		} else if (employee.isKitchenStaff()) {
			return "KitchenList";
		} else if (employee.isDeliveryStaff()) {
			return "DeliveryList";
		} else if (employee.isBusinessAnalyst()) {
			return "Reports";
		} else
		return "EmployeeIndex";
	}
	
	public String signOut() {
		employee = null;
		signedIn = false;
		return "EmployeeSignIn";
	}
	
	public String printStatus() {
		String t = status;
		status = "";
		return t;
	}
	
}