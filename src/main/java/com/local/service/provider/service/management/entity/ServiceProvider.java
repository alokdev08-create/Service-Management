package com.local.service.provider.service.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "service_providers")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 50)
	private String serviceType;

	@Column(nullable = false, length = 15)
	private String contactNumber;

	private String email;

	@Lob
	private String address;

	private Boolean availabilityStatus = true;

	private Integer rating;

	@Lob
	private String specialNotes;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
