package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId; // From Phase 2 Diagram
    
    private LocalDate date;
    private String timeSlot;
    
    @Enumerated(EnumType.STRING)
    private BookingStatus status; // Uses your defined Enum

    @ManyToOne
    private User organizer;

    @ManyToOne
    private Facility facility;
}

enum BookingStatus {
    PENDING, APPROVED, REJECTED, CANCELLED, COMPLETED
}