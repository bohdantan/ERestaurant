package com.bionic.edu.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.CategoryReportResults;
import com.bionic.edu.DailyReportResult;
import com.bionic.edu.FoodOrderStatus;
import com.bionic.edu.entity.FoodOrder;

@Repository
public class FoodOrderDaoImpl implements FoodOrderDao {
	@PersistenceContext
	private EntityManager em;

	public FoodOrder findById(int id) {
		return em.find(FoodOrder.class, id);
	}

	public void save(FoodOrder foodOrder) {
		em.persist(foodOrder);
	}
	
	public void setStatus(int id, FoodOrderStatus status) {
		FoodOrder fo = em.find(FoodOrder.class, id);
		if (fo != null) {
			fo.setStatus(status);
		}
	}

	public List<FoodOrder> deliveryList() {
		TypedQuery<FoodOrder> query = em.createQuery(
				"SELECT fo FROM FoodOrder fo ORDER BY fo.status, fo.time", 
				FoodOrder.class);
		return query.getResultList();
	}
	
	public List<FoodOrder> deliveryList(FoodOrderStatus status) {
		TypedQuery<FoodOrder> query = em.createQuery(
				"SELECT fo FROM FoodOrder fo WHERE fo.status = ?1 ORDER BY fo.time", 
				FoodOrder.class);
		query.setParameter(1, status);
		return query.getResultList();
	}
	
	public int getOrdersNumberByDate(LocalDate date) {
		TypedQuery<Long> query = em.createQuery(
				"SELECT COUNT(fo) FROM FoodOrder fo WHERE fo.time > ?1 AND fo.time < ?2", 
				Long.class);
		query.setParameter(1, java.sql.Timestamp.valueOf(date.atStartOfDay()));
		query.setParameter(2, java.sql.Timestamp.valueOf(date.plusDays(1).atStartOfDay()));
		int res = 0;
		try {
		res =  query.getSingleResult().intValue();
		} catch (Exception ex) {}
		return res;
	}
	
	public double getOrdersSumByDate(LocalDate date) {
		TypedQuery<Double> query = em.createQuery(
				//"SELECT SUM(oi.price) FROM FoodOrder fo, OrderItem oi "
				//+ "WHERE oi.foodOrder = fo AND fo.time > ?1 AND fo.time < ?2", 
				"SELECT SUM(oi.price) FROM OrderItem oi "
				+ "WHERE oi.foodOrder.time > ?1 AND oi.foodOrder.time < ?2",
				Double.class);
		query.setParameter(1, java.sql.Timestamp.valueOf(date.atStartOfDay()));
		query.setParameter(2, java.sql.Timestamp.valueOf(date.plusDays(1).atStartOfDay()));
		double res = 0;
		try {
		res =  query.getSingleResult();
		} catch (Exception ex) {}
		return res;
	}
	
	public List<DailyReportResult> getDailyReport(LocalDate d1, LocalDate d2) {
		TypedQuery<DailyReportResult> query = em.createQuery(
				"SELECT new com.bionic.edu.DailyReportResult" 
				+ "(fo.date, COUNT(fo), SUM(fo.orderSum)) "
				+ "FROM FoodOrder fo "
				+ "WHERE fo.date > ?1 AND fo.date < ?2 "
				+ "GROUP BY fo.date",
				
				DailyReportResult.class);
		query.setParameter(1, java.sql.Date.valueOf(d1));
		query.setParameter(2, java.sql.Date.valueOf(d2));
		return query.getResultList();
	}
	
	public List<CategoryReportResults> getCategoryReport(LocalDate d1, LocalDate d2) {
		TypedQuery<CategoryReportResults> query = em.createQuery(
				"SELECT new com.bionic.edu.CategoryReportResults" 
				+ "(oi.food.foodCategory.name, COUNT(oi.foodOrder), SUM(oi.price)) "
				+ "FROM OrderItem oi "
				+ "WHERE oi.foodOrder.date > ?1 AND oi.foodOrder.date < ?2 "
				+ "GROUP BY oi.food.foodCategory.name",
				CategoryReportResults.class);
		query.setParameter(1, java.sql.Date.valueOf(d1));
		query.setParameter(2, java.sql.Date.valueOf(d2));
		return query.getResultList();
	}
}
