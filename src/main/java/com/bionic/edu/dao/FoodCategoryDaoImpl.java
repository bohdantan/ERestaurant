package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.FoodCategory;

@Repository
public class FoodCategoryDaoImpl implements FoodCategoryDao {
	@PersistenceContext
	private EntityManager em;

	public FoodCategory findById(int id) {
		return em.find(FoodCategory.class, id);
	}

	public List<FoodCategory> findAll() {
		TypedQuery<FoodCategory> query = em.createQuery("SELECT fc FROM FoodCategory fc",
				FoodCategory.class);
		return query.getResultList();
	}
}
