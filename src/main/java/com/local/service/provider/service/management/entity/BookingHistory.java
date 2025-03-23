package com.local.service.provider.service.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "booking_history")
@Data
public class BookingHistory {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "booking_id", nullable = false)
	    private ServiceBooking booking;

	    @ManyToOne
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "service_provider_id", nullable = false)
	    private ServiceProvider serviceProvider;

	    @ManyToOne
	    @JoinColumn(name = "service_category_id", nullable = false)
	    private ServiceCategory serviceCategory;

	    private LocalDateTime bookingDate;

	    private LocalDateTime completionDate;

	    @Column(length = 20)
	    private String status = "Completed";

	    @Lob
	    private String feedback;

	    private Integer rating;

	    private LocalDateTime createdAt;

}
