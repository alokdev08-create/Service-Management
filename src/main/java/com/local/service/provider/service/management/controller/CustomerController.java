package com.local.service.provider.service.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.entity.Customer;
import com.local.service.provider.service.management.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	 private CustomerService customerService;
	
	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<Customer> createCustomerDetails(@RequestBody Customer customer) {
		 System.out.println("Received BookingPayment: " +customer );
		Customer savedCustomer = customerService.createCustomer(customer);
		return ResponseEntity.ok(savedCustomer);	
	}
	@GetMapping("/fetchByCustomeId")
	public ResponseEntity<Customer> fetchCustomerById(@RequestParam Integer id){
		Customer  fetchByCustomerId = customerService.fetchByCustomerId(id);
			return ResponseEntity.ok(fetchByCustomerId);
}
	@GetMapping("/fetchByCustomerName")
	public ResponseEntity<Customer>fetchCustomerByName(@RequestParam String name){
		Customer fetchByCustomerName = customerService.fetchByCustomerNamer(name);
		return ResponseEntity.ok(fetchByCustomerName);
	}
	@GetMapping("/fetchByCustomerEmail")
	public ResponseEntity<Customer>fetchByCustomerEmail(@RequestParam String email){
		Customer fetchByCustomerEmail = customerService.fetchByCustomerEmail(email);
				return ResponseEntity.ok(fetchByCustomerEmail);
	}
	@GetMapping("fetchByCustomerAddress")
	public ResponseEntity<List> fetchCustomerByAddress(@RequestParam String address){
		List<Customer>  costomer  =customerService.fetchByCustomerAddress(address);
		return ResponseEntity.ok(costomer);
	}
	
}