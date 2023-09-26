package com.payment.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentmanagementApplication.class, args);
	}

}
