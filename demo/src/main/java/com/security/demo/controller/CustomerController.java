package com.security.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.entity.Customer;

@RestController
public class CustomerController {

	final private List<Customer> customers = List.of(
			Customer.builder().id("001").name("Customer 1").email("c1@gmail.com").build(),
			Customer.builder().id("002").name("Customer 2").email("c2@gmail.com").build()
	);
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hello is exception");
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id) {
		List<Customer> customers = this.customers.stream().filter(item -> item.getId().equals(id)).toList();
		return ResponseEntity.ok(customers.get(0));
	}
	
	@GetMapping("/customer/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Customer>> getCustomerList() {
		List<Customer> customers = this.customers;
		return ResponseEntity.ok(customers);
	}
	
	
}
