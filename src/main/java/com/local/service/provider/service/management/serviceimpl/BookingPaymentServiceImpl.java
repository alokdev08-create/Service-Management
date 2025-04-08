package com.local.service.provider.service.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public List<BookingPayment> fetchAllPaymentBookingDetails() {
		return bookingPaymentRepository.findAll();
	}

	@Override
    public List<BookingPayment> fetchPaymentBookingById(Integer id) {
        return bookingPaymentRepository.findById(id);
    }

	@Override
	public List<BookingPayment> fetchByPaymentStatus(String paymentStatus) {
		return bookingPaymentRepository.findByPaymentStatus(paymentStatus);
	}

	@Override
	public List<BookingPayment> fetchByPaymentMethod(String paymentMethod) {
		return bookingPaymentRepository.findByPaymentMethod(paymentMethod);
	}

	@Override
	public List<BookingPayment> fetchByPaymentAmount(Double paymentAmount) {
		return bookingPaymentRepository.findByAmount(paymentAmount);
	}

	 @Override
	    public BookingPayment updateBookingPayment(Integer id, BookingPayment bookingPaymentDetails) {
	        Optional<BookingPayment> optionalBookingPayment = bookingPaymentRepository.findById(id);

	        if (optionalBookingPayment.isPresent()) {
	            BookingPayment existingBookingPayment = optionalBookingPayment.get();
	            existingBookingPayment.setPaymentDate(bookingPaymentDetails.getPaymentDate());
	            existingBookingPayment.setAmount(bookingPaymentDetails.getAmount());
	            existingBookingPayment.setPaymentStatus(bookingPaymentDetails.getPaymentStatus());
	            existingBookingPayment.setPaymentMethod(bookingPaymentDetails.getPaymentMethod());
	            existingBookingPayment.setUpdatedAt(bookingPaymentDetails.getUpdatedAt());

	            return bookingPaymentRepository.save(existingBookingPayment);
	        } else {
	            throw new RuntimeException("BookingPayment not found!");
	        }
}

	}
