package com.microservice.customer.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.address.entity.CustomerAddress;
import com.microservice.customer.address.exception.ResourceNotFoundException;
import com.microservice.customer.address.repository.CustomerAddressRepository;

@RestController
@RequestMapping("/addressAPI")
//@Api(tags = "Address Controller")
public class CustomerAddressController {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CustomerAddressController.class);
	
	@GetMapping("/address1")
    public String getAddress() {
		CustomerAddress addressObj = customerAddressRepository.findAll().get(0);
		return addressObj.getAddress1() + ", "+  addressObj.getAddress2() ;
	}
	
	@GetMapping("/address2")
    public String getAddressforCustomer() {
		return "address2";
	}
	
	@GetMapping("/circuitBreakerTest")
    public String testCircuitBreaker() {
		return "hello Neeraj";
	}
	
	
	@GetMapping(value = "/")
	//@ApiOperation(value = "Get All Address", response = String.class)
	public String helloCustomer() {
		logger.info("helloCustomer() is called....");
		return "Welcome XYZ!";
	}
	
	
	@GetMapping(value = "/getAddress/{id}")
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
	
	
	@GetMapping(value = "/getAll")
	//@ApiOperation(value = "Get All Address", response = List.class)
    public List <CustomerAddress> getAllAddress() {
		logger.info("getAllAddress() is called....");
        List<CustomerAddress> result =  this.customerAddressRepository.findAll();
        return result;
    }
	
	@PutMapping(value = "/{id}")
    public CustomerAddress updateAddress(@RequestBody CustomerAddress customerAddressEntity, @PathVariable("id") long customerId) {
		logger.info("updateAddress() is called....");
		CustomerAddress existingCustomer = this.customerAddressRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + customerId));
		existingCustomer.setAddress1(customerAddressEntity.getAddress1());
		existingCustomer.setAddress2(customerAddressEntity.getAddress2());
        return this.customerAddressRepository.save(existingCustomer);
    }

}
