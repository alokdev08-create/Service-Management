package com.local.service.provider.service.management.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.ServiceBooking;
import com.local.service.provider.service.management.repositry.ServiceBookingRepository;
import com.local.service.provider.service.management.service.ServiceBookingService;

@Service
public class ServiceBookingImpl implements ServiceBookingService {

	@Autowired
	private ServiceBookingRepository serviceBookingRepository;

	@Override
	public List<ServiceBooking> fetchAllServiceBooking() {
		return serviceBookingRepository.findAll();
	}

	@Override
	public ServiceBooking createServiceBookingDetails(ServiceBooking serviceBooking) {
	    if (serviceBooking.getCustomer() == null || serviceBooking.getServiceProvider() == null || serviceBooking.getServiceCategory() == null) {
	        throw new IllegalArgumentException("Customer, Service Provider, and Service Category must not be null.");
	    }

	    // Ensure timestamps are handled properly (optional)
	    serviceBooking.setBookingDate(serviceBooking.getBookingDate() != null ? serviceBooking.getBookingDate() : LocalDateTime.now());
	    serviceBooking.setAppointmentDate(serviceBooking.getAppointmentDate() != null ? serviceBooking.getAppointmentDate() : LocalDateTime.now());
	    
	    // Save entity in the repository
	    return serviceBookingRepository.save(serviceBooking);
	}

}
