package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}

	public void save(Customer customer) {
		em.persist(customer);
	}

	public Customer findByName(String name) {
		TypedQuery<Customer> query = em.createQuery(
				"SELECT c FROM Customer c WHERE c.name = ?1", Customer.class);
		query.setParameter(1, name);
		Customer c = null;
		try {
			c = query.getSingleResult();
		} catch (Exception ex) {
		}
		return c;
	}

	public void update(Customer customer) {
		em.merge(customer);
	}
}
