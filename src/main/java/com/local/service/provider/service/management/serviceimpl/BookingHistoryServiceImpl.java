package com.local.service.provider.service.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.BookingHistory;
import com.local.service.provider.service.management.repositry.BookingHistoryRepository;
import com.local.service.provider.service.management.service.BookingHistoryService;
@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {


    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    @Override
    public List<BookingHistory> getAllBookingHistories() {
        return bookingHistoryRepository.findAll();
    }

    @Override
    public Optional<BookingHistory> getBookingHistoryById(Long id) {
        return bookingHistoryRepository.findById(id);
    }

    @Override
    public BookingHistory createBookingHistory(BookingHistory bookingHistory) {
        return bookingHistoryRepository.save(bookingHistory);
    }

    @Override
    public BookingHistory updateBookingHistory(Long id, BookingHistory bookingHistoryDetails) {
        Optional<BookingHistory> optionalBookingHistory = bookingHistoryRepository.findById(id);

        if (optionalBookingHistory.isPresent()) {
            BookingHistory bookingHistory = optionalBookingHistory.get();
            bookingHistory.setBooking(bookingHistoryDetails.getBooking());
            bookingHistory.setBookingDate(bookingHistoryDetails.getBookingDate());
            bookingHistory.setCompletionDate(bookingHistoryDetails.getCompletionDate());
            bookingHistory.setStatus(bookingHistoryDetails.getStatus());
            bookingHistory.setFeedback(bookingHistoryDetails.getFeedback());
            bookingHistory.setRating(bookingHistoryDetails.getRating());

            return bookingHistoryRepository.save(bookingHistory);
        }
        return null; // Consider throwing an exception instead for better error handling.
    }

    @Override
    public boolean deleteBookingHistory(Long id) {
        if (bookingHistoryRepository.existsById(id)) {
            bookingHistoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
	}

