package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Food;

@Repository
public class FoodDaoImpl implements FoodDao {
	@PersistenceContext
	private EntityManager em;

	public Food findById(int id) {
		return em.find(Food.class, id);
	}

	public void save(Food food) {
		if (food.getId() == 0) {
			em.persist(food);
		} else {
			em.merge(food);
		}
	}
	
	/*public void update(Food food) {
		em.merge(food);
	}*/
	
	public List<Food> findByCategory(int id) {
		TypedQuery<Food> query = em.createQuery(
				"SELECT f FROM Food f WHERE f.foodCategory.id = ?1 AND f.activated = true", 
				Food.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public List<Food> findAll() {
		TypedQuery<Food> query = em.createQuery(
				"SELECT f FROM Food f", 
				Food.class);
		return query.getResultList();
	}
}
