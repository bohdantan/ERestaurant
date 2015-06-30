package com.bionic.edu.bean;

import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.entity.FoodOrder;
import com.bionic.edu.service.FoodOrderService;

@Named
@Scope("session")
public class DeliveryBean {
	@Inject
	private FoodOrderService foodOrderService;

	private List<FoodOrder> foodOrders = null;

	private LinkedHashMap<String, String> list;
	private String filterStatus;

	public DeliveryBean() {
		list = new LinkedHashMap<String, String>();
		for (FoodOrderStatus fos : FoodOrderStatus.values()) {
			list.put(fos.toString(), String.valueOf(fos.ordinal()));
		}
		filterStatus = String.valueOf(FoodOrderStatus.READY_FOR_SHIPMENT.ordinal());
	}

	public LinkedHashMap<String, String> getList() {
		return list;
	}

	public void setList(LinkedHashMap<String, String> list) {
		this.list = list;
	}

	public String getFilterStatus() {
		return filterStatus;
	}

	public void setFilterStatus(String filterStatus) {
		this.filterStatus = filterStatus;
	}

	public boolean buttonRendered(String status) {
		FoodOrderStatus fos = FoodOrderStatus.valueOf(status);
		if (fos == FoodOrderStatus.READY_FOR_SHIPMENT
				|| fos == FoodOrderStatus.DELIVERING) {
			return true;
		} else {
			return false;
		}
	}

	public String buttonName(String status) {
		FoodOrderStatus fos = FoodOrderStatus.valueOf(status);
		if (fos == FoodOrderStatus.READY_FOR_SHIPMENT) {
			return "Mark as delivering";
		} else if (fos == FoodOrderStatus.DELIVERING) {
			return "Mark as delivered";
		} else {
			return "";
		}
	}

	public String buttonAction(String orderId, String status) {
		int id = Integer.valueOf(orderId);
		FoodOrderStatus fos = FoodOrderStatus.valueOf(status);
		fos = FoodOrderStatus.values()[fos.ordinal() + 1];
		foodOrderService.setStatus(id, fos);
		return "DeliveryList";
	}

	public List<FoodOrder> getFoodOrders() {
		return foodOrders;
	}

	public void setFoodOrders(List<FoodOrder> foodOrders) {
		this.foodOrders = foodOrders;
	}

	public void refreshList() {
		FoodOrderStatus fos = FoodOrderStatus.values()[Integer.valueOf(filterStatus)];
		foodOrders = foodOrderService.deliveryList(fos);
	}
	
	public void filter(ValueChangeEvent event) {
		filterStatus = (String)event.getNewValue();
		System.out.println(filterStatus);
		refreshList();
	}
}