package com.bionic.edu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.service.FoodCategoryService;
import com.bionic.edu.service.FoodOrderService;
import com.bionic.edu.service.FoodService;
import com.bionic.edu.service.OrderItemService;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		
		//EmployeeService employeeService = context.getBean(EmployeeService.class);
		//CustomerService customerService = context.getBean(CustomerService.class);
		FoodOrderService foodOrderService = context.getBean(FoodOrderService.class);
		FoodCategoryService foodCategoryService = context.getBean(FoodCategoryService.class);
		FoodService foodService = context.getBean(FoodService.class);
		OrderItemService orderItemService = context.getBean(OrderItemService.class);
		
		orderItemService.setDone(604);
		//System.out.println(foodCategoryService.findAll());
		//System.out.println(foodService.findByCategory(1));
		
//		System.out.println(foodOrderService.getCategoryReport(
//				LocalDate.now().minusDays(15), LocalDate.now().minusDays(5)));
		
//		System.out.println(foodOrderService.getDailyReport(
//				LocalDate.now().minusDays(30), LocalDate.now().minusDays(15)));
		
		//System.out.println(foodOrderService.deliveryList(FoodOrderStatus.CREATED));
		
		//System.out.println(foodOrderService.deliveryList());
		
		//System.out.println(orderItemService.kitchenList());
		
		/*FoodOrder fo = foodOrderService.findById(402);
		System.out.println(fo);
		for (OrderItem oi : fo.getOrderItems())
			System.out.println(oi);*/
		
		/*FoodOrder fo = new FoodOrder();
		fo.setStatus(FoodOrderStatus.CREATED);
		fo.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		fo.setCustomer(customerService.findById(1));
		List<OrderItem> l = new ArrayList<OrderItem>();
		fo.setOrderItems(l);
		OrderItem oi = new OrderItem();
		oi.setFood(foodService.findById(101));
		oi.setFoodOrder(fo);
		oi.setQuantity(2);
		l.add(oi);
		
		oi = new OrderItem();
		oi.setFood(foodService.findById(102));
		oi.setFoodOrder(fo);
		oi.setQuantity(3);
		l.add(oi);
		
		foodOrderService.save(fo);
		System.out.println(foodOrderService.findById(fo.getId()));*/
		
		//System.out.println(customerService.signIn("Paul", "pass"));
		
		/*Customer c = new Customer();
		c.setName("Paul");
		c.setPassword("pass");
		c.setAddress("Kyiv, Radisna str., 1");
		System.out.println(customerService.save(c));
		System.out.println(customerService.findById(c.getId()));*/
		
		//System.out.println(employeeService.signIn("Jack", "pass"));
		
		/*Employee e = new Employee();
		e.setName("James");
		e.setPassword("pass");
		e.setActivated(true);
		System.out.println(employeeService.save(e));
		System.out.println(employeeService.findAll());*/
		
		/*System.out.println(employeeService.findAll());
		Employee e = new Employee();
		e.setName("Jack");
		e.setPassword("pass");
		e.setActivated(false);
		employeeService.save(e);
		System.out.println(employeeService.findAll());
		Employee e1 = employeeService.findById(e.getId());
		e1.setActivated(true);
		employeeService.update(e1);
		System.out.println(employeeService.findAll());*/
		
		/*List<FoodCategory> l = foodCategoryService.findAll();
		System.out.println(l);*/
		
		/*FoodCategory fc = foodCategoryService.findById(2);
		Food f = new Food();
		f.setName("Chicken soup");
		f.setFoodCategory(fc);
		f.setKitchenMade(true);
		f.setPrice(25);
		foodService.save(f);
		
		f = new Food();
		f.setName("Tomato soup");
		f.setFoodCategory(fc);
		f.setKitchenMade(true);
		f.setPrice(20);
		foodService.save(f);
		
		System.out.println(fc);
		for (Food f1 : fc.getFood()) {
			System.out.println(f1);
		}*/
		
		/*OrderItem oi = new OrderItem();
		oi.setFood(foodService.findById(1));
		oi.setFoodOrder(foodOrderService.findById(401));
		oi.setPrice(15);
		oi.setQuantity(2);
		oi.setDone(false);
		orderItemService.save(oi);
		int id = oi.getId();
		System.out.println(orderItemService.findById(id));*/
		
		/*Food f = new Food();
		f.setName("Coca-Cola");
		f.setKitchenMade(false);
		f.setActivated(true);
		f.setPrice(15);
		f.setFoodCategory(foodCategoryService.findById(1));
		foodService.save(f);
		int id = f.getId();
		System.out.println(foodService.findById(id));*/
		
		/*FoodOrder fo = new FoodOrder();
		fo.setCustomer(customerService.findById(1));
		fo.setStatus(FoodOrderStatus.READY_FOR_SHIPMENT);
		fo.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		foodOrderService.save(fo);
		int id = fo.getId();
		System.out.println(foodOrderService.findById(id));*/
	}

}
