package com.local.service.provider.service.management.service;

import java.util.List;

import com.local.service.provider.service.management.entity.ServiceBooking;

public interface ServiceBookingService {

	List<ServiceBooking> fetchAllServiceBooking();

	ServiceBooking createServiceBookingDetails(ServiceBooking serviceBooking);
	}
