package com.accenture.lkm.business.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerBean {
	private int customerId;
	private String customerName;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date billingDate;
	private Double bill;
	private String customerType;

	public CustomerBean() {
	}

	public CustomerBean(int customerId, String customerName, Date billingDate, Double bill, String customerType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.billingDate = billingDate;
		this.bill = bill;
		this.customerType = customerType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
