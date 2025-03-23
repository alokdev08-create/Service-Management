package com.local.service.provider.service.management.service;

import java.util.List;
import java.util.Optional;

import com.local.service.provider.service.management.entity.BookingHistory;

public interface BookingHistoryService {
	List<BookingHistory> getAllBookingHistories();

	Optional<BookingHistory> getBookingHistoryById(Long id);

	BookingHistory createBookingHistory(BookingHistory bookingHistory);

	BookingHistory updateBookingHistory(Long id, BookingHistory bookingHistoryDetails);

	boolean deleteBookingHistory(Long id);
}
