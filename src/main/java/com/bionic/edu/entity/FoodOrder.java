package com.bionic.edu.entity;

import java.util.Collection;

import javax.persistence.*;

import com.bionic.edu.FoodOrderStatus;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	private java.sql.Timestamp time;
	private java.sql.Date date;
	private FoodOrderStatus status;
	private double orderSum;
	@OneToMany(mappedBy="foodOrder", cascade=CascadeType.PERSIST)
	private Collection<OrderItem> orderItems;
	
	public FoodOrder() {
	}

	public double getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(double orderSum) {
		this.orderSum = orderSum;
	}

	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Collection<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public FoodOrderStatus getStatus() {
		return status;
	}

	public void setStatus(FoodOrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", customer=" + customer + ", time="
				+ time + ", status=" + status + "]";
	}
}
