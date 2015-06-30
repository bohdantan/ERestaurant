package com.bionic.edu.service;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.CategoryReportResults;
import com.bionic.edu.DailyReportResult;
import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.dao.FoodOrderDao;
import com.bionic.edu.entity.FoodOrder;

@Named
public class FoodOrderServiceImpl implements FoodOrderService {
	@Inject
	private FoodOrderDao foodOrderDao;
	
	public FoodOrder findById(int id) {
		return foodOrderDao.findById(id);
	}
	
	@Transactional
	public void save(FoodOrder foodOrder) {
		foodOrderDao.save(foodOrder);
	}
	
	@Transactional
	public void setStatus(int id, FoodOrderStatus status) {
		foodOrderDao.setStatus(id, status);
	}

	@Override
	public List<FoodOrder> deliveryList() {
		return foodOrderDao.deliveryList();
	}
	
	public List<FoodOrder> deliveryList(FoodOrderStatus status) {
		return foodOrderDao.deliveryList(status);
	}
	
	public List<DailyReportResult> getDailyReport(LocalDate d1, LocalDate d2) {
		/*List<DailyReportResult> l = new ArrayList<DailyReportResult>();
		while (d1.isBefore(d2)) {
			l.add(new DailyReportResult(d1, 
					foodOrderDao.getOrdersNumberByDate(d1), foodOrderDao.getOrdersSumByDate(d1)));
			d1 = d1.plusDays(1);
		}
		return l;*/
		return foodOrderDao.getDailyReport(d1, d2);
	}
	
	public List<CategoryReportResults> getCategoryReport(LocalDate d1, LocalDate d2) {
		return foodOrderDao.getCategoryReport(d1, d2);
	}
}
