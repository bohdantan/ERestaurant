package com.bionic.edu;

public class CategoryReportResults {
	String categoryName;
	long ordersNumber;
	double ordersSum;
	
	public CategoryReportResults() {
	}

	public CategoryReportResults(String categoryName, long ordersNumber, double ordersSum) {
		this.categoryName = categoryName;
		this.ordersNumber = ordersNumber;
		this.ordersSum = ordersSum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getOrdersNumber() {
		return ordersNumber;
	}

	public void setOrdersNumber(long ordersNumber) {
		this.ordersNumber = ordersNumber;
	}

	public double getOrdersSum() {
		return ordersSum;
	}

	public void setOrdersSum(double ordersSum) {
		this.ordersSum = ordersSum;
	}

	@Override
	public String toString() {
		return "DailyReportResult [categoryName=" + categoryName + ", ordersNumber="
				+ ordersNumber + ", ordersSum=" + ordersSum + "]";
	}
}
