package com.bionic.edu;

public class DailyReportResult {
	//LocalDate date;
	java.sql.Date date;
	long ordersNumber;
	double ordersSum;
	
	public DailyReportResult() {
	}

	public DailyReportResult(java.sql.Date date, long ordersNumber, double ordersSum) {
		this.date = date;
		this.ordersNumber = ordersNumber;
		this.ordersSum = ordersSum;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
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
		return "DailyReportResult [date=" + date + ", ordersNumber="
				+ ordersNumber + ", ordersSum=" + ordersSum + "]";
	}
}
