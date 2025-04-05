package com.local.service.provider.service.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.repositry.BookingPaymentRepository;
import com.local.service.provider.service.management.service.BookingPaymentService;
@Service
public class BookingPaymentServiceImpl implements BookingPaymentService {
	@Autowired
	private BookingPaymentRepository bookingPaymentRepository;
	@Override
	public BookingPayment createBookingPayment(BookingPayment bookingPayment) {
		return bookingPaymentRepository.save(bookingPayment);
	}
	public List<BookingPayment> fetchAllPaymentBookingDetails() {
	    // Logic to fetch and return the list
	    return bookingPaymentRepository.findAll(); // Example repository call
	}
	@Override
	public BookingPayment fetchPaymentBookingById(Integer id) {
		return bookingPaymentRepository.findById(id);
	}
	@Override
	public List<BookingPayment> fetchByPaymentStatus(String paymentStatus) {
		// TODO Auto-generated method stub
		 return bookingPaymentRepository.findByPaymentStatus(paymentStatus);
	
	}
	@Override
	public List<BookingPayment> fetchByPaymentMethod(String paymentMethod) {
		// TODO Auto-generated method stub
		return bookingPaymentRepository.findByPaymentMethod(paymentMethod);
	}
	@Override
	public List<BookingPayment> fetchByPaymentAmount(Double paymentAmount) {
		// TODO Auto-generated method stub
		return bookingPaymentRepository.findByAmount(paymentAmount);
	}	
}
