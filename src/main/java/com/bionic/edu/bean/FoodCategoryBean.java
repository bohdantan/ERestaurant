package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.FoodCategory;
import com.bionic.edu.service.FoodCategoryService;

@Named
@Scope("session")
public class FoodCategoryBean {
	@Inject
	private FoodCategoryService foodCategoryService;
	
	private List<FoodCategory> foodCategories = null;
	
	public List<FoodCategory> getFoodCategories() {
		return foodCategories;
	}

	public void setFoodCategories(List<FoodCategory> foodCategories) {
		this.foodCategories = foodCategories;
	}

	public void refreshList() {
		foodCategories = foodCategoryService.findAll();
	}
}
