package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.CategoryReportResults;
import com.bionic.edu.DailyReportResult;
import com.bionic.edu.service.FoodOrderService;

@Named
@Scope("session")
public class ReportBean {
	@Inject
	private FoodOrderService foodOrderService;
	
	private List<DailyReportResult> dailyReport = null;
	private List<CategoryReportResults> categoryReport = null;
	
	private java.util.Date dateFrom;
	private java.util.Date dateTo;
	
	public List<DailyReportResult> getDailyReport() {
		return dailyReport;
	}

	public void setDailyReport(List<DailyReportResult> dailyReport) {
		this.dailyReport = dailyReport;
	}

	public List<CategoryReportResults> getCategoryReport() {
		return categoryReport;
	}

	public void setCategoryReport(List<CategoryReportResults> categoryReport) {
		this.categoryReport = categoryReport;
	}

	public java.util.Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(java.util.Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public java.util.Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(java.util.Date dateTo) {
		this.dateTo = dateTo;
	}

	public void refreshDailyReport() {
		dailyReport = foodOrderService.getDailyReport(
				new java.sql.Date(dateFrom.getTime()).toLocalDate(), 
				new java.sql.Date(dateTo.getTime()).toLocalDate());
	}
	
	public void refreshCategoryReport() {
		categoryReport = foodOrderService.getCategoryReport(
				new java.sql.Date(dateFrom.getTime()).toLocalDate(), 
				new java.sql.Date(dateTo.getTime()).toLocalDate());
	}
}