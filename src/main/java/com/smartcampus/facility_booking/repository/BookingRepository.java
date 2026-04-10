package com.smartcampus.facility_booking.repository;

import com.smartcampus.facility_booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // This allows you to save and find bookings 
}