package com.local.service.provider.service.management.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.entity.ServiceBooking;
import com.local.service.provider.service.management.repositry.ServiceBookingRepository;
import com.local.service.provider.service.management.service.ServiceBookingService;

@Service
public class ServiceBookingImpl implements ServiceBookingService {

	@Autowired
	private ServiceBookingRepository serviceBookingRepository;

	// Fetch all service bookings
	@Override
	public List<ServiceBooking> fetchAllServiceBooking() {
		return serviceBookingRepository.findAll();
	}

	
	@Override
	public ServiceBooking createServiceBookingDetails(ServiceBooking serviceBooking) {
		if (serviceBooking.getCustomer() == null || serviceBooking.getServiceProvider() == null
				|| serviceBooking.getServiceCategory() == null) {
			throw new IllegalArgumentException("Customer, Service Provider, and Service Category must not be null.");
		}

		// Handle timestamps
		serviceBooking.setBookingDate(
				serviceBooking.getBookingDate() != null ? serviceBooking.getBookingDate() : LocalDateTime.now());
		serviceBooking
				.setAppointmentDate(serviceBooking.getAppointmentDate() != null ? serviceBooking.getAppointmentDate()
						: LocalDateTime.now());
		serviceBooking.setCreatedAt(LocalDateTime.now());

		// Save entity
		return serviceBookingRepository.save(serviceBooking);
	}


	@Override
	public BookingPayment updateBookingPayment(Integer id, BookingPayment bookingPaymentDetails) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ServiceBooking updateServiceBookingDetails(Integer id, ServiceBooking serviceBookingDetails) {
		Optional<ServiceBooking> optionalServiceBooking = serviceBookingRepository.findById(id);

		if (optionalServiceBooking.isPresent()) {
			ServiceBooking existingServiceBooking = optionalServiceBooking.get();
			if (serviceBookingDetails.getCustomer() != null) {
				existingServiceBooking.setCustomer(serviceBookingDetails.getCustomer());
			}
			if (serviceBookingDetails.getServiceProvider() != null) {
				existingServiceBooking.setServiceProvider(serviceBookingDetails.getServiceProvider());
			}
			if (serviceBookingDetails.getServiceCategory() != null) {
				existingServiceBooking.setServiceCategory(serviceBookingDetails.getServiceCategory());
			}
			if (serviceBookingDetails.getBookingDate() != null) {
				existingServiceBooking.setBookingDate(serviceBookingDetails.getBookingDate());
			}
			if (serviceBookingDetails.getAppointmentDate() != null) {
				existingServiceBooking.setAppointmentDate(serviceBookingDetails.getAppointmentDate());
			}
			if (serviceBookingDetails.getStatus() != null) {
				existingServiceBooking.setStatus(serviceBookingDetails.getStatus());
			}
			if (serviceBookingDetails.getNotes() != null) {
				existingServiceBooking.setNotes(serviceBookingDetails.getNotes());
			}
			existingServiceBooking.setUpdatedAt(LocalDateTime.now());

			return serviceBookingRepository.save(existingServiceBooking);
		} else {
			throw new RuntimeException("ServiceBooking not found for id: " + id);
		}
	}
	}
