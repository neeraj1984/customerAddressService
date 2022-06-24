package com.microservice.customer.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.customer.address.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long>{

}
