package com.local.service.provider.service.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.ServiceBooking;
import com.local.service.provider.service.management.service.ServiceBookingService;

@RestController
@RequestMapping("/api/booking-service")
public class ServiceBookingController {
	@Autowired
	private ServiceBookingService serviceBookingService;

	@GetMapping("/fetchAllServiceBookingDetails")
	public ResponseEntity<List<ServiceBooking>> fetchAllServiceBookings() {
		List<ServiceBooking> serviceBooking = serviceBookingService.fetchAllServiceBooking();
		return ResponseEntity.ok(serviceBooking);
	}

	@PostMapping("/saveServiceBookingDetails")
	public ResponseEntity<ServiceBooking> createServiceBookingDetails(@RequestBody ServiceBooking serviceBooking) {
		ServiceBooking saveServiceBooking = serviceBookingService.createServiceBookingDetails(serviceBooking);
		return ResponseEntity.ok(saveServiceBooking);

	}
}