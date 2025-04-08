package com.local.service.provider.service.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.Customer;
import com.local.service.provider.service.management.entity.ServiceCategory;
import com.local.service.provider.service.management.entity.ServiceProvider;
import com.local.service.provider.service.management.entity.ServiceRequest;
import com.local.service.provider.service.management.repositry.CustomerRepository;
import com.local.service.provider.service.management.repositry.ServiceCategoryRepository;
import com.local.service.provider.service.management.repositry.ServiceProviderRepository;
import com.local.service.provider.service.management.repositry.ServiceRequestRepository;
import com.local.service.provider.service.management.service.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	@Autowired
	private ServiceCategoryRepository serviceCategoryRepository;


	@Override
	public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
	    // Fetch and validate the Customer
	    Customer customer = customerRepository.findById(serviceRequest.getCustomer().getId());
	    if (customer == null) {
	        throw new RuntimeException("Customer not found with ID: " + serviceRequest.getCustomer().getId());
	    }
	    serviceRequest.setCustomer(customer);

	    // Fetch and validate the ServiceProvider
	    ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceRequest.getServiceProvider().getId());
	    if (serviceProvider == null) {
	        throw new RuntimeException("Service Provider not found with ID: " + serviceRequest.getServiceProvider().getId());
	    }
	    serviceRequest.setServiceProvider(serviceProvider);

	    // Fetch and validate the ServiceCategory
	    ServiceCategory serviceCategory = serviceCategoryRepository.findById(serviceRequest.getServiceCategory().getId());
	    if (serviceCategory == null) {
	        throw new RuntimeException("Service Category not found with ID: " + serviceRequest.getServiceCategory().getId());
	    }
	    serviceRequest.setServiceCategory(serviceCategory);

	    // Save the ServiceRequest
	    return serviceRequestRepository.save(serviceRequest);
	}


	@Override
	public List<ServiceRequest> fetchServiceRequestById(Integer id) {
		return serviceRequestRepository.findById(id);
	}


	@Override
	public List<ServiceRequest> fetchAllServiceRequestDetails() {
		return serviceRequestRepository.findAll();
	}
}
