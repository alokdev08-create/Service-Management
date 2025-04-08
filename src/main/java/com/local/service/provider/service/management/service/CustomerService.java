package com.local.service.provider.service.management.service;

import java.util.List;

import com.local.service.provider.service.management.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	Customer fetchByCustomerId(Integer id);
	Customer fetchByCustomerNamer(String name);
	Customer fetchByCustomerEmail(String email);
	List<Customer> fetchByCustomerAddress(String address);
	Customer updateCustomer(Integer id, Customer customerDetails);
	    }
