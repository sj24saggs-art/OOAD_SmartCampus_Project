package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    private String description;
    
    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;
}

enum MaintenanceStatus {
    RAISED, ASSIGNED, IN_PROGRESS, RESOLVED, CLOSED
}