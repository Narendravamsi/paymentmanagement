package com.payment.management.model;

import java.math.BigDecimal;

public class PaymentSum {

	public String emailId;
	
	public static BigDecimal orderprice=BigDecimal.ZERO;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BigDecimal getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(BigDecimal orderprice) {
		this.orderprice = orderprice;
	}
	
	
	
	
	
	
	
	
}
