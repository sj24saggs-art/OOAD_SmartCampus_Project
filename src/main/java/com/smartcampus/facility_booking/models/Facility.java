package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Facility {
    @Id
    private String facilityId;
    private String name;
    private String location;
    private int capacity;
    
    @Enumerated(EnumType.STRING)
    private FacilityAvailability availability;
}

enum FacilityAvailability {
    AVAILABLE, BOOKED, UNDER_MAINTENANCE, BLOCKED
}