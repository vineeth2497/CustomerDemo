package com.accenture.lkm.business.bean;

public class CustomerTypeBean {
	private String customerType;
	private Double minimumBill;
	private Double maximumBill;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Double getMinimumBill() {
		return minimumBill;
	}

	public void setMinimumBill(Double minimumBill) {
		this.minimumBill = minimumBill;
	}

	public Double getMaximumBill() {
		return maximumBill;
	}

	public void setMaximumBill(Double maximumBill) {
		this.maximumBill = maximumBill;
	}

	public CustomerTypeBean(String customerType, Double minimumBill, Double maximumBill) {
		super();
		this.customerType = customerType;
		this.minimumBill = minimumBill;
		this.maximumBill = maximumBill;
	}

	public CustomerTypeBean() {

	}

}
