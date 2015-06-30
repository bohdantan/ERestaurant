package com.bionic.edu.dao;

import com.bionic.edu.entity.Customer;

public interface CustomerDao {
	Customer findById(int id);
	Customer findByName(String name);
	void save(Customer customer);
	void update(Customer customer);
}
