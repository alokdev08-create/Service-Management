package com.local.service.provider.service.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.BookingHistory;
import com.local.service.provider.service.management.entity.ServiceProvider;
import com.local.service.provider.service.management.service.ServiceProviderService;
@RestController
@RequestMapping("/api/service-provider")
public class ServiceProviderController {
	@Autowired
	private ServiceProviderService  serviceProviderService;
	
	@PostMapping("/saveServiceProviderDetails")
	public ResponseEntity<ServiceProvider> createServiceProviderDetails(@RequestBody ServiceProvider serviceProvider) {
		ServiceProvider savedServiceProvider = serviceProviderService.createServiceProvider(serviceProvider);
		return ResponseEntity.ok(savedServiceProvider);

}
}