package com.microservice.customer.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
        System.out.println("address service is initializing....");
		SpringApplication.run(App.class);
    }

}
