package com.local.service.provider.service.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.ServiceRequest;
import com.local.service.provider.service.management.service.ServiceRequestService;

@RestController
@RequestMapping("/api/Service-request")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService serviceRequestService;

	@PostMapping("/createServiceRequest")
	public ResponseEntity<?> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
		return ResponseEntity.ok(serviceRequestService.createServiceRequest(serviceRequest));

	}

}
