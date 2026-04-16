package com.smartcampus.facility_booking.service;

import com.smartcampus.facility_booking.models.FacilityAvailability;
import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.models.Facility;
import com.smartcampus.facility_booking.repository.BookingRepository;
import com.smartcampus.facility_booking.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityManagerService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    // Approve a booking request
    public Booking approveBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        // FIX: Using the Enum instead of a String
        booking.setStatus(Booking.BookingStatus.APPROVED);
        return bookingRepository.save(booking);
    }

    // Reject a booking request
    public Booking rejectBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        // FIX: Using the Enum instead of a String
        booking.setStatus(Booking.BookingStatus.REJECTED);
        return bookingRepository.save(booking);
    }

    // Update facility status
    public Facility updateFacilityStatus(Long facilityId, String status) {
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new RuntimeException("Facility not found"));
    
    // FIX: Match the variable name 'availability' in Facility.java
    // And convert the String input to the Enum type
    facility.setAvailability(FacilityAvailability.valueOf(status.toUpperCase()));
    
    return facilityRepository.save(facility);
}

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}