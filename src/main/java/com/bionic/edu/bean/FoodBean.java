package com.bionic.edu.bean;

import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Food;
import com.bionic.edu.entity.FoodCategory;
import com.bionic.edu.service.FoodCategoryService;
import com.bionic.edu.service.FoodService;

@Named
@Scope("session")
public class FoodBean {
	@Inject
	private FoodService foodService;
	
	@Inject
	private FoodCategoryService foodCategoryService;

	private List<Food> foodList = null;
	private Food food;
	private LinkedHashMap<String, String> categoryIdName;
	private LinkedHashMap<String, FoodCategory> idCategory;
	private String data;

	private void loadCategories() {
		categoryIdName = new LinkedHashMap<String, String>();
		idCategory = new LinkedHashMap<String, FoodCategory>();
		List<FoodCategory> fcList = foodCategoryService.findAll();
		for (FoodCategory fc : fcList) {
			categoryIdName.put(fc.getName(), String.valueOf(fc.getId()));
			idCategory.put(String.valueOf(fc.getId()), fc);
		}
	}

	public LinkedHashMap<String, String> getCategoryIdName() {
		return categoryIdName;
	}

	public void setCategoryIdName(LinkedHashMap<String, String> categoryIdName) {
		this.categoryIdName = categoryIdName;
	}

	public LinkedHashMap<String, FoodCategory> getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(LinkedHashMap<String, FoodCategory> idCategory) {
		this.idCategory = idCategory;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void refreshList() {
		foodList = foodService.findAll();
	}

	public String saveFood() {
		food.setFoodCategory(idCategory.get(data));
		foodService.save(food);
		return "FoodList";
	}

	public String addFood() {
		loadCategories();
		food = new Food();
		return "newFood";
	}

	public String editFood(String id) {
		loadCategories();
		food = foodService.findById(Integer.valueOf(id));
		data = String.valueOf(food.getFoodCategory().getId());
		return "newFood";
	}
}
