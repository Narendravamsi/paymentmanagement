package com.payment.management.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.management.entity.PaymentEntity;
import com.payment.management.model.EmailIdPayment;
import com.payment.management.model.PaymentRequest;
import com.payment.management.model.PaymentResponse;
import com.payment.management.model.PaymentSum;
import com.payment.management.model.PaymentUpdate;
import com.payment.management.repository.PaymentRepository;

@Service
public class PaymentServiceimpl implements PaymentService {

	@Autowired
	PaymentRepository repo;

	@Override
	public List<PaymentResponse> getPaymentDetails() {

		List<PaymentResponse> list = new ArrayList<>();

		List<PaymentEntity> paymentData = (List<PaymentEntity>) repo.findAll();

		BigDecimal sum = new BigDecimal("0");

		for (PaymentEntity payments : paymentData) {

			PaymentResponse paymentResponse = new PaymentResponse();

			paymentResponse.setPaymentId(payments.getPaymentId());
			paymentResponse.setOrderId(payments.getOrderId());
			paymentResponse.setEmailId(payments.getEmailId());
			paymentResponse.setOrderCost(payments.getOrderCost());
			paymentResponse.setPaymentStatus(payments.getPaymentStatus());
			sum = sum.add(payments.getOrderCost());	

			list.add(paymentResponse);

		}

		return list;
	}

	@Override
	public String addPaymentDetails(PaymentRequest request) {

		PaymentEntity payment = new PaymentEntity();

		payment.setEmailId(request.getEmailId());
		payment.setOrderCost(request.getOrderCost());
		payment.setOrderId(request.getOrderId());
		payment.setPaymentStatus(request.getPaymentStatus());

		repo.save(payment);

		return "your data inserted sucessfully";
	}

	@Override
	public PaymentUpdate updatePaymentDetails(PaymentUpdate request, Integer paymentId) {

		Optional<PaymentEntity> data = repo.findById(paymentId);

		PaymentEntity payment = data.get();

		payment.setPaymentStatus(request.getPaymentStatus());
		payment.setPaymentId(paymentId);

		repo.save(payment);

		PaymentUpdate paymentUpdated = new PaymentUpdate();

		paymentUpdated.setPaymentId(paymentId);
		paymentUpdated.setPaymentStatus(payment.getPaymentStatus());
		paymentUpdated.setMessage("your data is updated");

		return paymentUpdated;
	}

	@Override
	public String deletePaymentDetails(Integer paymentId) {

		repo.deleteById(paymentId);

		return "your payment data is deleted sucessfully";
	}

	@Override
	public List<EmailIdPayment> loadPaymentByEmailId(String emailId) {

		List<EmailIdPayment> list = new ArrayList<>();

		List<PaymentEntity> data = repo.findByEmailId(emailId);

		for (PaymentEntity payment : data) {

			EmailIdPayment paymentDetails = new EmailIdPayment();

			paymentDetails.setPaymentId(payment.paymentId);
			paymentDetails.setOrderId(payment.getOrderId());
			paymentDetails.setOrderCost(payment.getOrderCost());
			paymentDetails.setPaymentStatus(payment.getPaymentStatus());

			list.add(paymentDetails);

		}

		return list;
	}

	@Override
	public PaymentSum addTotalCost(String emailId) {

		List<PaymentEntity> payment = (List<PaymentEntity>) repo.findByEmailId(emailId);

		PaymentSum s1 = new PaymentSum();

		BigDecimal sum = BigDecimal.ZERO;
		for (PaymentEntity payments : payment) {

			sum = sum.add(payments.getOrderCost());

		}
		s1.setEmailId(emailId);
		s1.setOrderprice(sum);

		return s1;
	}

}
