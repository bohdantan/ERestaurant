package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.FoodCategory;

public interface FoodCategoryDao {
	FoodCategory findById(int id);
	public List<FoodCategory> findAll();
}
