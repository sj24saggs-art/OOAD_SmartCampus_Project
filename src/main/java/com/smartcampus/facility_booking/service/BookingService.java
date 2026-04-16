package com.smartcampus.facility_booking.service;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getMyBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public String requestBooking(Booking newBooking) {
        // Validate that end time is after start time
        if (newBooking.getEndTime().isBefore(newBooking.getStartTime())) {
            return "End time must be after start time.";
        }

        List<Booking> all = bookingRepository.findAll();
        for (Booking existing : all) {
            // Only check conflicts for the same facility that aren't rejected
            if (existing.getBookingReference().equalsIgnoreCase(newBooking.getBookingReference()) && 
                existing.getStatus() != Booking.BookingStatus.REJECTED) {
                
                // Logic: (StartA < EndB) and (EndA > StartB) means they overlap 
                if (newBooking.getStartTime().isBefore(existing.getEndTime()) && 
                    newBooking.getEndTime().isAfter(existing.getStartTime())) {
                    return "CONFLICT";
                }
            }
        }
        
        newBooking.setStatus(Booking.BookingStatus.PENDING);
        bookingRepository.save(newBooking);
        return "SUCCESS";
    }
}