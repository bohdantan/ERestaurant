package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.dao.FoodCategoryDao;
import com.bionic.edu.entity.FoodCategory;

@Named
public class FoodCategoryServiceImpl implements FoodCategoryService {
	@Inject
	private FoodCategoryDao foodCategoryDao;

	public FoodCategory findById(int id) {
		return foodCategoryDao.findById(id);
	}

	public List<FoodCategory> findAll() {
		return foodCategoryDao.findAll();
	}
}
