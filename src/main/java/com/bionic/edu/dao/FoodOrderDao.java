package com.bionic.edu.dao;

import java.time.LocalDate;
import java.util.List;

import com.bionic.edu.CategoryReportResults;
import com.bionic.edu.DailyReportResult;
import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.entity.FoodOrder;

public interface FoodOrderDao {
	FoodOrder findById(int id);
	void save(FoodOrder foodOrder);
	void setStatus(int id, FoodOrderStatus status);
	List<FoodOrder> deliveryList();
	List<FoodOrder> deliveryList(FoodOrderStatus status);
	//int getOrdersNumberByDate(LocalDate date);
	//double getOrdersSumByDate(LocalDate date);
	List<DailyReportResult> getDailyReport(LocalDate d1, LocalDate d2);
	List<CategoryReportResults> getCategoryReport(LocalDate d1, LocalDate d2);
}
