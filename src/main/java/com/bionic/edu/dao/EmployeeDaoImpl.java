package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;

	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}
	
	public Employee findByName(String name){
	     TypedQuery<Employee> query = em.createQuery(
	    		 "SELECT e FROM Employee e WHERE e.name = ?1", Employee.class);
	     query.setParameter(1, name);
	     Employee e = null;
	     try {
	    	 e = query.getSingleResult();
	     } catch(Exception ex) {}
	     return e;
	}

	
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",
				Employee.class);
		return query.getResultList();
	}

	public void save(Employee employee) {
		if (employee.getId() == 0) {
			em.persist(employee);
		} else {
			em.merge(employee);
		}
	}
	
	/*public void update(Employee employee) {
		em.merge(employee);
	}*/
}
