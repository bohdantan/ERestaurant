package com.bionic.edu.service;

import com.bionic.edu.entity.Customer;

public interface CustomerService {
	Customer findById(int id);
	boolean save(Customer customer);
	void update(Customer customer);
	Customer signIn(String name, String password);
}
