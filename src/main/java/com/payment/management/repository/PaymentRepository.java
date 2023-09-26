package com.payment.management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.payment.management.entity.PaymentEntity;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer>{

	List<PaymentEntity> findByEmailId(String emailId);

}
