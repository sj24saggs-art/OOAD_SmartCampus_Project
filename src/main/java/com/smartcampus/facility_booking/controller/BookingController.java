package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.models.MaintenanceRequest;
import com.smartcampus.facility_booking.repository.MaintenanceRequestRepository;
import com.smartcampus.facility_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Booking book(@RequestBody Booking booking) {
        return bookingService.requestBooking(booking);
    }

    @GetMapping("/my-bookings")
    public List<Booking> viewStatus() {
        return bookingService.getMyBookings();
    }

    @DeleteMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "Booking " + id + " has been successfully cancelled.";
    }

    @PutMapping("/modify/{id}")
    public Booking modify(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @Autowired
    private MaintenanceRequestRepository maintenanceRepo;

    @PostMapping("/maintenance/report")
    public MaintenanceRequest reportIssue(@RequestBody MaintenanceRequest request) {
    return maintenanceRepo.save(request);
    }
}