package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entity.OrderItem;

public interface OrderItemService {
	OrderItem findById(int id);
	void save(OrderItem orderItem);
	void setDone(int id);
	List<OrderItem> kitchenList();
}
