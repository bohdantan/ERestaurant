package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="foodCategoryId")
	private FoodCategory foodCategory;
	private String name;
	private double price;
	private boolean kitchenMade;
	private boolean activated;
	
	public Food() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isKitchenMade() {
		return kitchenMade;
	}

	public void setKitchenMade(boolean kitchenMade) {
		this.kitchenMade = kitchenMade;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", foodCategory=" + foodCategory + ", name="
				+ name + ", price=" + price + ", kitchenMade=" + kitchenMade
				+ ", activated=" + activated + "]";
	}
}
