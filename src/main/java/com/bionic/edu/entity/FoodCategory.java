package com.bionic.edu.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class FoodCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="foodCategory")
	private Collection<Food> food;

	public FoodCategory() {
	}

	public Collection<Food> getFood() {
		return food;
	}

	public void setFood(Collection<Food> food) {
		this.food = food;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FoodCategory [id=" + id + ", name=" + name + "]";
	}
}
