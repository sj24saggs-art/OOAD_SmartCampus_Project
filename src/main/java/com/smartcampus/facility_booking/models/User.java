package com.smartcampus.facility_booking.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {
    @Id
    private String userId; // From Phase 2 Diagram
    private String name;
    private String email;
    private String password;
}