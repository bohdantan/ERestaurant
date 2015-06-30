package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.OrderItem;
import com.bionic.edu.service.OrderItemService;

@Named
@Scope("session")
public class KitchenBean {
	@Inject
	private OrderItemService orderItemService;
	
	private List<OrderItem> orderItems = null;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void refreshList() {
		orderItems = orderItemService.kitchenList();
	}
	
	public String markDone(String id) {
		int i = Integer.valueOf(id);
		System.out.println(id + " " + i);
		orderItemService.setDone(i);
		return "kitchenList";
	}
}