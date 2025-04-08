package com.local.service.provider.service.management.service;

import java.util.List;

import com.local.service.provider.service.management.entity.ServiceRequest;

public interface ServiceRequestService {

	ServiceRequest  createServiceRequest(ServiceRequest serviceRequest);

	List<ServiceRequest> fetchServiceRequestById(Integer id);

	List<ServiceRequest> fetchAllServiceRequestDetails();

}
