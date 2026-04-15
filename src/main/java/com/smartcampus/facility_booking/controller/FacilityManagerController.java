package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.models.Facility;
import com.smartcampus.facility_booking.service.FacilityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility-manager")
public class FacilityManagerController {

    @Autowired
    private FacilityManagerService facilityManagerService;

    // Approve booking
    @PutMapping("/approve/{bookingId}")
    public Booking approveBooking(@PathVariable Long bookingId) {
        return facilityManagerService.approveBooking(bookingId);
    }

    // Reject booking
    @PutMapping("/reject/{bookingId}")
    public Booking rejectBooking(@PathVariable Long bookingId) {
        return facilityManagerService.rejectBooking(bookingId);
    }

    // Update facility status
    @PutMapping("/facility/{facilityId}/status")
    public Facility updateFacilityStatus(@PathVariable Long facilityId,
                                          @RequestParam String status) {
        return facilityManagerService.updateFacilityStatus(facilityId, status);
    }

    // View all bookings
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return facilityManagerService.getAllBookings();
    }

    // View all facilities
    @GetMapping("/facilities")
    public List<Facility> getAllFacilities() {
        return facilityManagerService.getAllFacilities();
    }
}