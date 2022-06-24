package com.microservice.customer.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.customer.address.entity.CustomerAddress;
import com.microservice.customer.address.repository.CustomerAddressRepository;

@Service
public class AddressService {

	@Autowired
    private CustomerAddressRepository customerAddressRepository;
	
	public List<CustomerAddress> getAll() {
		System.out.println("getAll() called....");
		return customerAddressRepository.findAll();
	}
}
