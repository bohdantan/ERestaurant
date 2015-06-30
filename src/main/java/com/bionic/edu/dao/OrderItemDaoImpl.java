package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.OrderItem;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
	@PersistenceContext
	private EntityManager em;

	public OrderItem findById(int id) {
		return em.find(OrderItem.class, id);
	}

	public void save(OrderItem orderItem) {
		em.persist(orderItem);
	}
	
	public void setDone(int id) {
		OrderItem oi = em.find(OrderItem.class, id);
		if (oi != null) {
			oi.setDone(true);
		}
	}
	
	public List<OrderItem> kitchenList() {
		TypedQuery<OrderItem> query = em.createQuery(
				"SELECT oi FROM OrderItem oi WHERE oi.done = false AND oi.food.kitchenMade = true "
				+ "ORDER BY oi.foodOrder.time", 
				OrderItem.class);
		return query.getResultList();
	}
}
