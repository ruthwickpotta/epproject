package com.model;

public class Order extends Product{
	 int orderId;
     
	 int qunatity;
	 String date;
	 String name;
	
	

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String email) {
		this.name = name;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
