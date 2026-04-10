package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.*;
import java.util.List;

public class ReportGenerator {

    public void generateSystemReport(List<Facility> facilities, List<Booking> bookings) {
        System.out.println("=== SYSTEM ANALYTICS REPORT ===");

        long operationalCount = facilities.stream()
                .filter(Facility::isOperational)
                .count();
        System.out.println("Operational Facilities: " + operationalCount + "/" + facilities.size());

        long totalApproved = bookings.stream()
                .filter(b -> b.getStatus() != null && b.getStatus().name().equals("APPROVED"))
                .count();
        System.out.println("Total Successful Bookings: " + totalApproved);
        System.out.println("===============================");
    }
}