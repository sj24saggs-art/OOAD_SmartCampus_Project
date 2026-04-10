package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.*;
import java.util.List;

public class AdminSystemController {

    // Major 1: Manage System & Schedule (Conflict Prevention)
    public boolean approveBooking(Booking request, List<Booking> masterSchedule) {
        for (Booking existing : masterSchedule) {

            // Fix 1: Use getFacility() because the field is an Object, not a String ID
            // Fix 2: Use .name() to compare Enum to String, or use the Enum type directly
            if (existing.getFacility().getId().equals(request.getFacility().getId()) &&
                    existing.getStatus() == Booking.BookingStatus.APPROVED) {

                // Fix 3: Logic to check for time overlap (Ensure getters match Booking.java
                // fields)
                if (request.getStartTime().isBefore(existing.getEndTime()) &&
                        request.getEndTime().isAfter(existing.getStartTime())) {
                    System.out.println("Conflict Detected: Facility already booked.");
                    return false;
                }
            }
        }

        // Fix 4: Set status using the Enum type, not a String
        request.setStatus(Booking.BookingStatus.APPROVED);
        return true;
    }
}