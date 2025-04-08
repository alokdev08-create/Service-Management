package com.local.service.provider.service.management.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.local.service.provider.service.management.entity.BookingPayment;
import com.local.service.provider.service.management.service.BookingPaymentService;

@RestController
@RequestMapping("/api/booking-payment")
public class BookingPaymentController {

    @Autowired
    private BookingPaymentService bookingPaymentService;

    @PostMapping("/saveBookingPayment")
    public ResponseEntity<BookingPayment> createBookingPayment(@RequestBody BookingPayment bookingPayment) {
        System.out.println("Received BookingPayment: " + bookingPayment);
        BookingPayment savedBookingPayment = bookingPaymentService.createBookingPayment(bookingPayment);
        return ResponseEntity.ok(savedBookingPayment);
    }

    @GetMapping("/fetchAllPaymentBookingDetails")
    public ResponseEntity<List<BookingPayment>> fetchAllPaymentBookingDetails() {
        List<BookingPayment> payments = bookingPaymentService.fetchAllPaymentBookingDetails();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/fetchPaymentBookingById")
    public ResponseEntity<BookingPayment> fetchPaymentBookingById(@RequestParam Integer id) {
        BookingPayment payment = bookingPaymentService.fetchPaymentBookingById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/fetchByPaymentStatus")
    public ResponseEntity<List<BookingPayment>> fetchByPaymentStatus(@RequestParam String paymentStatus) {
        List<BookingPayment> paymentsBookingDetailsByStatus = bookingPaymentService.fetchByPaymentStatus(paymentStatus);
        return ResponseEntity.ok(paymentsBookingDetailsByStatus);
    }

    @GetMapping("/fetchByPaymentMethod")
    public ResponseEntity<List<BookingPayment>> fetchByPaymentMethod(@RequestParam String paymentMethod) {
        List<BookingPayment> paymentsBookingDetailsByMethod = bookingPaymentService.fetchByPaymentMethod(paymentMethod);
        return ResponseEntity.ok(paymentsBookingDetailsByMethod);
    }

    @GetMapping("/fetchByPaymentAmount")
    public ResponseEntity<List<BookingPayment>> fetchByPaymentAmount(@RequestParam Double amount) {
        if (amount == null || amount <= 0) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        List<BookingPayment> paymentsBookingDetailsByAmount = bookingPaymentService.fetchByPaymentAmount(amount);
        return ResponseEntity.ok(paymentsBookingDetailsByAmount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingPayment> updateBookingPayment(@PathVariable Long id, @RequestBody BookingPayment bookingPaymentDetails) {
        BookingPayment updatedBookingPayment = bookingPaymentService.updateBookingPayment(id, bookingPaymentDetails);
        if (updatedBookingPayment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBookingPayment);
    }
}
