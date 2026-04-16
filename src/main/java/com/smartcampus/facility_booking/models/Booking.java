package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingReference; 
    private String eventType;        
    private LocalDateTime startTime;
    private LocalDateTime endTime; // New field for time-slot management

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    public enum BookingStatus { PENDING, APPROVED, REJECTED }

    // Setters and Getters
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public String getBookingReference() { return bookingReference; }
    public void setBookingReference(String br) { this.bookingReference = br; }
    public String getEventType() { return eventType; }
    public void setEventType(String et) { this.eventType = et; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime st) { this.startTime = st; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime et) { this.endTime = et; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus s) { this.status = s; }
}