package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.dao.FoodOrderDao;
import com.bionic.edu.dao.OrderItemDao;
import com.bionic.edu.entity.FoodOrder;
import com.bionic.edu.entity.OrderItem;

@Named
public class OrderItemServiceImpl implements OrderItemService {
	@Inject
	private OrderItemDao orderItemDao;
	@Inject
	private FoodOrderDao foodOrderDao;
	
	public OrderItem findById(int id) {
		return orderItemDao.findById(id);
	}
	
	@Transactional
	public void save(OrderItem orderItem) {
		orderItemDao.save(orderItem);
	}

	@Transactional
	public void setDone(int id) {
		orderItemDao.setDone(id);
		OrderItem oi = orderItemDao.findById(id);
		FoodOrder fo = oi.getFoodOrder();
		if (fo.getStatus() == FoodOrderStatus.CREATED) {
			for (OrderItem coi : fo.getOrderItems()) {
				if (!coi.isDone() && coi.getFood().isKitchenMade())
					return;
			}
			foodOrderDao.setStatus(fo.getId(), FoodOrderStatus.READY_FOR_SHIPMENT);
		}
	}

	@Override
	public List<OrderItem> kitchenList() {
		return orderItemDao.kitchenList();
	}
}
