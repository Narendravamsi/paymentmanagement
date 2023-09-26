package com.payment.management.service;

import java.util.List;

import com.payment.management.model.EmailIdPayment;
import com.payment.management.model.PaymentRequest;
import com.payment.management.model.PaymentResponse;
import com.payment.management.model.PaymentSum;
import com.payment.management.model.PaymentUpdate;

public interface PaymentService {

	List<PaymentResponse> getPaymentDetails();
	
	String addPaymentDetails(PaymentRequest request);
	
	PaymentUpdate updatePaymentDetails(PaymentUpdate request, Integer paymentId);
	
	String deletePaymentDetails( Integer paymentId);
	
	List<EmailIdPayment> loadPaymentByEmailId(String emailId); 
	
	PaymentSum addTotalCost(String emailId);
}
