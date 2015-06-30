package com.bionic.edu.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.CustomerDao;
import com.bionic.edu.entity.Customer;

@Named
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private CustomerDao customerDao;
	
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
	
	@Transactional
	public boolean save(Customer customer) {
		if (customer.getId() != 0 || customerDao.findByName(customer.getName()) == null) {
			customerDao.save(customer);
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	
	public Customer signIn(String name, String password) {
		Customer c = customerDao.findByName(name);
		if (c != null && password.equals(c.getPassword())) {
			return c;
		} else {
			return null;
		}
	}
}
