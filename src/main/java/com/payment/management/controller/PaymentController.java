package com.payment.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.management.model.EmailIdPayment;
import com.payment.management.model.PaymentRequest;
import com.payment.management.model.PaymentResponse;
import com.payment.management.model.PaymentSum;
import com.payment.management.model.PaymentUpdate;
import com.payment.management.service.PaymentService;



@RestController
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	
	@RequestMapping(method=RequestMethod.GET,path="get/all/payment")
	public List<PaymentResponse> getPaymentDetails() {
		return service.getPaymentDetails();
	}

	@RequestMapping(method=RequestMethod.POST,path="add/payment/details" )
	public String addPaymentDetails(@RequestBody PaymentRequest request) {
		
		
		return service.addPaymentDetails(request);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,path="update/payment/details/{paymentId}")
	public PaymentUpdate updatePaymentDetails(@RequestBody PaymentUpdate request ,@PathVariable Integer paymentId) {
	
		return service.updatePaymentDetails(request, paymentId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,path="delete/payment/details/{paymentId}")
	public String deletePaymentDetails(@PathVariable Integer paymentId) {
		
		return service.deletePaymentDetails(paymentId);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/{emailId}")
	public List<EmailIdPayment> loadPaymentByEmailId(@PathVariable("emailId") String emailId) {

		return service.loadPaymentByEmailId(emailId);
	}
  
	@RequestMapping(method=RequestMethod.GET,path="add/all/cost/{emailId}")
	public PaymentSum addTotalCost(@PathVariable("emailId") String emailId) {
		
		
		return service.addTotalCost(emailId);
	}

}
