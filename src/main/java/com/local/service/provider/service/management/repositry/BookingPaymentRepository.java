package com.local.service.provider.service.management.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.service.provider.service.management.entity.BookingPayment;
@Repository
public interface BookingPaymentRepository extends JpaRepository< BookingPayment, Long> {

	BookingPayment findById(Integer id);

	List<BookingPayment> findByPaymentStatus(String paymentStatus);
	List<BookingPayment> findByPaymentMethod(String paymentMethod);

	List<BookingPayment> findByAmount(Double paymentAmount);

}
