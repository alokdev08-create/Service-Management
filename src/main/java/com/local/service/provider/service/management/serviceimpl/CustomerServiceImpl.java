package com.local.service.provider.service.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.entity.Customer;
import com.local.service.provider.service.management.repositry.BookingPaymentRepository;
import com.local.service.provider.service.management.repositry.CustomerRepository;
import com.local.service.provider.service.management.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer) ;
	}

	@Override
	public Customer fetchByCustomerId(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer fetchByCustomerNamer(String name) {
		
		return customerRepository.findByName(name);
	}

	@Override
	public Customer fetchByCustomerEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public List<Customer> fetchByCustomerAddress(String address) {
		
		return customerRepository.findByAddress(address);
	}

	 @Override
	    public Customer updateCustomer(Integer id, Customer customerDetails) {
	        Optional<Customer> optionalCustomer = customerRepository.findById(id);

	        if (optionalCustomer.isPresent()) {
	            Customer existingCustomer = optionalCustomer.get();
	            existingCustomer.setName(customerDetails.getName());
	            existingCustomer.setContactNumber(customerDetails.getContactNumber());
	            existingCustomer.setEmail(customerDetails.getEmail());
	            existingCustomer.setAddress(customerDetails.getAddress());
	            existingCustomer.setUpdatedAt(customerDetails.getUpdatedAt());

	            return customerRepository.save(existingCustomer);
	        }

	        throw new RuntimeException("Customer not found!");
	    }
}
