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

    public Booking requestBooking(Booking booking) {
        booking.setStatus(Booking.BookingStatus.PENDING); 
        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id)
            .map(existingBooking -> {
                // This is the fix: Instead of calling undefined getters, 
                // we save the whole updated object but keep the original ID.
                updatedBooking.setId(id); 
                updatedBooking.setStatus(Booking.BookingStatus.PENDING);
                return bookingRepository.save(updatedBooking);
            }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}