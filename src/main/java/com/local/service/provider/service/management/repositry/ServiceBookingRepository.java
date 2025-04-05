package com.local.service.provider.service.management.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.entity.ServiceBooking;
@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {
}
