package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.OrderItem;

public interface OrderItemDao {
	OrderItem findById(int id);
	void save(OrderItem orderItem);
	void setDone(int id);
	List<OrderItem> kitchenList();
}
