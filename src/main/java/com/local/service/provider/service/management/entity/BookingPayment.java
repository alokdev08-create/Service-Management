package com.local.service.provider.service.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "booking_payments")
public class BookingPayment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

//	    @ManyToOne
//	    @JoinColumn(name = "booking_id", nullable = false)
//	    private ServiceBooking booking;

	    private LocalDateTime paymentDate;

	    private Double amount;

	    @Column(length = 20)
	    private String paymentStatus = "Pending";

	    @Column(length = 50)
	    private String paymentMethod;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;
}
