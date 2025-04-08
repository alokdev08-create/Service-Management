package com.local.service.provider.service.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.local.service.provider.service.management.entity.BookingPayment;



public interface BookingPaymentService {

	public List<BookingPayment> fetchAllPaymentBookingDetails();

	BookingPayment createBookingPayment(BookingPayment bookingPayment);

	public BookingPayment fetchPaymentBookingById(Integer id);

	public List<BookingPayment> fetchByPaymentStatus(String paymentStatus);

	public List<BookingPayment> fetchByPaymentMethod(String paymentMethod);
	public List<BookingPayment> fetchByPaymentAmount(Double paymentAmount);

	public BookingPayment updateBookingPayment(long id, BookingPayment bookingPaymentDetails);
	

}
