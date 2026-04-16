package com.smartcampus.facility_booking.service;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getPendingBookings() {
        return bookingRepository.findAll(); 
    }

    public void approveBooking(Long id) {
        bookingRepository.findById(id).ifPresent(b -> {
            b.setStatus(Booking.BookingStatus.APPROVED);
            bookingRepository.save(b);
        });
    }
}