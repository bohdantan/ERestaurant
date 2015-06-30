package com.bionic.edu.service;

import java.time.LocalDate;
import java.util.List;

import com.bionic.edu.CategoryReportResults;
import com.bionic.edu.DailyReportResult;
import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.entity.FoodOrder;

public interface FoodOrderService {
	FoodOrder findById(int id);
	void save(FoodOrder foodOrder);
	void setStatus(int id, FoodOrderStatus status);
	List<FoodOrder> deliveryList();
	List<FoodOrder> deliveryList(FoodOrderStatus status);
	List<DailyReportResult> getDailyReport(LocalDate d1, LocalDate d2);
	List<CategoryReportResults> getCategoryReport(LocalDate d1, LocalDate d2);
}
