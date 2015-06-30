package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.Food;

public interface FoodDao {
	Food findById(int id);
	void save(Food food);
	//void update(Food food);
	List<Food> findByCategory(int id);
	List<Food> findAll();
}
