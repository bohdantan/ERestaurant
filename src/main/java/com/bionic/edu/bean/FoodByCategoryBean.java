package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Food;
import com.bionic.edu.service.FoodService;

@Named
@Scope("session")
public class FoodByCategoryBean {
	@Inject
	private FoodService foodService;

	private List<Food> food = null;

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public String showCategory(String id) {
		food = foodService.findByCategory(Integer.valueOf(id));
		return "FoodByCategoryList";
	}
}
