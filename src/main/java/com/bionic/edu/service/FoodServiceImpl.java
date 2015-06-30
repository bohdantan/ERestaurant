package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.FoodDao;
import com.bionic.edu.entity.Food;

@Named
public class FoodServiceImpl implements FoodService{
	@Inject
	private FoodDao foodDao;
	
	public Food findById(int id) {
		return foodDao.findById(id);
	}
	
	@Transactional
	public void save(Food food) {
		foodDao.save(food);
	}
	
	/*@Transactional
	public void update(Food food) {
		foodDao.update(food);
	}*/
	
	public List<Food> findByCategory(int id) {
		return foodDao.findByCategory(id);
	}
	
	public List<Food> findAll() {
		return foodDao.findAll();
	}
}
