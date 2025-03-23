package com.local.service.provider.service.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.BookingHistory;
import com.local.service.provider.service.management.service.BookingHistoryService;

@RestController
@RequestMapping("/api/booking-history")
public class BookingHistoryController {
	@Autowired
	private BookingHistoryService bookingHistoryService;

	@GetMapping
	public ResponseEntity<List<BookingHistory>> getAllBookingHistories() {
		List<BookingHistory> bookingHistories = bookingHistoryService.getAllBookingHistories();
		return ResponseEntity.ok(bookingHistories); // Wrap the service method’s output with ResponseEntity
	}

	@GetMapping("fetchBookingHistoryById/{id}")
	public ResponseEntity<BookingHistory> getBookingHistoryById(@PathVariable Long id) {
		Optional<BookingHistory> bookingHistory = bookingHistoryService.getBookingHistoryById(id);
		return bookingHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/saveBookingHistory")
	public ResponseEntity<BookingHistory> createBookingHistory(@RequestBody BookingHistory bookingHistory) {
		 System.out.println("Received BookingHistory: " + bookingHistory);
		BookingHistory savedBookingHistory = bookingHistoryService.createBookingHistory(bookingHistory);
		return ResponseEntity.ok(savedBookingHistory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookingHistory> updateBookingHistory(@PathVariable Long id,
			@RequestBody BookingHistory bookingHistoryDetails) {
		BookingHistory updatedBookingHistory = bookingHistoryService.updateBookingHistory(id, bookingHistoryDetails);

		if (updatedBookingHistory != null) {
			return ResponseEntity.ok(updatedBookingHistory);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookingHistory(@PathVariable Long id) {
		boolean isDeleted = bookingHistoryService.deleteBookingHistory(id);
		if (isDeleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
