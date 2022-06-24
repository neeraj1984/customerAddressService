package com.microservice.customer.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.address.entity.CustomerAddress;
import com.microservice.customer.address.repository.CustomerAddressRepository;

@RestController
@RequestMapping("/addressAPI")
public class CustomerAddressController {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	@RequestMapping("/address1")
    public String getAddress() {
		CustomerAddress addressObj = customerAddressRepository.findAll().get(0);
		return addressObj.getAddress1() + ", "+  addressObj.getAddress2() ;
	}
	
	@RequestMapping("/address2")
    public String getAddressforCustomer() {
		return "address2";
	}
	
	@RequestMapping("/circuitBreakerTest")
    public String testCircuitBreaker() {
		return "hello Neeraj";
	}

}
