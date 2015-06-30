package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="foodOrderId")
	private FoodOrder foodOrder;
	@ManyToOne
	@JoinColumn(name="foodId")
	private Food food;
	private boolean done;
	private double price;
	
	public OrderItem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", foodOrder=" + foodOrder + ", food="
				+ food + ", done=" + done
				+ ", price=" + price + "]";
	}
}
