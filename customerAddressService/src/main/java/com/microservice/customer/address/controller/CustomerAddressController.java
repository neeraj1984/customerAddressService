package com.microservice.customer.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.address.entity.CustomerAddress;
import com.microservice.customer.address.exception.ResourceNotFoundException;
import com.microservice.customer.address.repository.CustomerAddressRepository;

@RestController
@RequestMapping("/addressAPI")
public class CustomerAddressController {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CustomerAddressController.class);
	
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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloCustomer() {
		logger.info("helloCustomer() is called....");
		return "Welcome XYZ!";
	}
	
	
	@RequestMapping(value = "/getAddress/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getAddress(@PathVariable("id") long id) {
		logger.info("getAddress() is called....");
		CustomerAddress customerAddress = customerAddressRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no record exists with id "+id));
		return "Address is: "+customerAddress.getAddress1();
	}
	
	
	@PostMapping
    public CustomerAddress createAddress(@RequestBody CustomerAddress customerAddressEntity) {
		logger.info("createAddress() is called....");
        return this.customerAddressRepository.save(customerAddressEntity);
    }
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List <CustomerAddress> getAllAddress() {
		logger.info("getAllAddress() is called....");
        List<CustomerAddress> result =  this.customerAddressRepository.findAll();
        return result;
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CustomerAddress updateAddress(@RequestBody CustomerAddress customerAddressEntity, @PathVariable("id") long customerId) {
		logger.info("updateAddress() is called....");
		CustomerAddress existingCustomer = this.customerAddressRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + customerId));
		existingCustomer.setAddress1(customerAddressEntity.getAddress1());
		existingCustomer.setAddress2(customerAddressEntity.getAddress2());
        return this.customerAddressRepository.save(existingCustomer);
    }

}
