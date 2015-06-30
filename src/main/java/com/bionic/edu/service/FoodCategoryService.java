package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entity.FoodCategory;

public interface FoodCategoryService {
	FoodCategory findById(int id);
	public List<FoodCategory> findAll();
}
