package com.bionic.edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.derby.iapi.sql.compile.CostEstimate;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.entity.Customer;
import com.bionic.edu.entity.FoodOrder;
import com.bionic.edu.entity.OrderItem;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.FoodOrderService;
import com.bionic.edu.service.FoodService;


@Named
@Scope("session")
public class CustomerBean {
	@Inject
	private CustomerService customerService;
	@Inject
	private FoodService foodService;
	@Inject
	private FoodOrderService foodOrderService;
	
	private String status = "";
	
	private boolean signedIn;
	private Customer customer;
	private List<OrderItem> orderList = new ArrayList<OrderItem>();
	private double sum;
	private int count;
	
	private java.util.Date customerBirthDate;
	
	public java.util.Date getCustomerBirthDate() {
		return customerBirthDate;
	}
	public void setCustomerBirthDate(java.util.Date customerBirthDate) {
		this.customerBirthDate = customerBirthDate;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isSignedIn() {
		return signedIn;
	}
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItem> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderItem> orderList) {
		this.orderList = orderList;
	}
	
	public void startRegister() {
		customer = new Customer();
	}
	
	public String finishRegister() {
		if (customerBirthDate != null) {
			customer.setBirthDate(new java.sql.Date(customerBirthDate.getTime()));
		}
		customerBirthDate = null;
		if (customerService.save(customer)) {
			signedIn = true;
			return "FoodCategoryList";
		}
		status = "User with this name already exists, try again";
		return "Register";
	}
	
	public void startSignIn() {
		customer = new Customer();
	}
	
	public String finishSignIn() {
		customer = customerService.signIn(customer.getName(), customer.getPassword());
		if (customer == null) {
			status = "Bad login or password, try again"; 
			return "SignIn";
		}
		signedIn = true;
		return "FoodCategoryList";
	}
	
	public String signOut() {
		customer = null;
		signedIn = false;
		return "FoodCategoryList";
	}
	
	public String addToCart(String foodId) {
		OrderItem oi = new OrderItem();
		oi.setFood(foodService.findById(Integer.valueOf(foodId)));
		oi.setPrice(oi.getFood().getPrice());
		sum += oi.getPrice();
		count += 1;
		orderList.add(oi);
		return "";
	}
	
	public String deleteFromCart(String foodId) {
		int id = Integer.valueOf(foodId);
		for (int i=0; i<orderList.size(); ++i) {
			if (orderList.get(i).getFood().getId() == id) {
				sum -= orderList.get(i).getPrice();
				count -= 1;
				orderList.remove(i);
				return "Cart";
			}
		}
		return "Cart";
	}
	
	public String submitCart() {
		if (customer == null || customer.getId() == 0) {
			customer = new Customer();
			return "DeliveryDetails";
		}
		FoodOrder fo = new FoodOrder();
		fo.setCustomer(customer);
		fo.setDate(new java.sql.Date(new java.util.Date().getTime()));
		fo.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		fo.setStatus(FoodOrderStatus.CREATED);
		for (OrderItem oi : orderList) {
			oi.setFoodOrder(fo);
		}
		fo.setOrderItems(orderList);
		fo.setOrderSum(sum);
		foodOrderService.save(fo);
		
		sum = 0;
		count = 0;
		orderList = new ArrayList<OrderItem>();
		if (!signedIn) {
			customer = null;
		}
		return "ThanksForOrder";
	}
	
	public String submitDetails() {
		if (!customerService.save(customer)) {
			status = "Name already exists, try again";
			return "DeliveryDetails";
		}
		return submitCart();
	}
	
	public String printStatus() {
		String t = status;
		status = "";
		return t;
	}
}