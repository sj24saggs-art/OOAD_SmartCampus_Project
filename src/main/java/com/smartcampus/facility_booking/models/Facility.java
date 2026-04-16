package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for database persistence

    private String facilityId; // Your business logic ID (e.g., "FAC-001")

    private String name;

    private String type;

    private String location;

    private int capacity;

    /**
     * Major Use Case 3: Facility Health tracking.
     * Used by the Admin to generate reports on facility status.
     */
    private boolean isOperational;

    /**
     * Minor Use Case 3: Read-only status for general campus users.
     */
    @Enumerated(EnumType.STRING)
    private FacilityAvailability availability;

    // Custom constructor for quick instantiation in your application
    public Facility(String facilityId, String name, String type, String location, int capacity, boolean isOperational) {
        this.facilityId = facilityId;
        this.name = name;
        this.type = type;
        this.location = location;
        this.capacity = capacity;
        this.isOperational = isOperational;
        this.availability = FacilityAvailability.AVAILABLE;
    }
}