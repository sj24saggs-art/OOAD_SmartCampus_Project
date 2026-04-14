package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.*;
import com.smartcampus.facility_booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminWebController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    // Admin Dashboard (Schedule Oversight)
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        model.addAttribute("facilities", facilityRepository.findAll());
        return "admin/dashboard";
    }

    // Public Viewer Role
    @GetMapping("/events")
    public String publicEvents(Model model) {
        model.addAttribute("events", bookingRepository.findAll().stream()
            .filter(b -> b.getStatus() == Booking.BookingStatus.APPROVED)
            .toList());
        return "public/events";
    }

    // Reports View
    @GetMapping("/admin/reports")
    public String viewReports(Model model) {
        model.addAttribute("totalBookings", bookingRepository.count());
        model.addAttribute("facilities", facilityRepository.findAll());
        return "admin/reports";
    }

    // Minor Use Case 3: Read-only calendar/schedule view
    @GetMapping("/schedule")
    public String viewSchedule(Model model) {
        // Fetch all approved bookings to show the "busy" slots on the calendar
        model.addAttribute("bookings", bookingRepository.findAll().stream()
            .filter(b -> b.getStatus() == Booking.BookingStatus.APPROVED)
            .sorted((a, b) -> a.getStartTime().compareTo(b.getStartTime()))
            .toList());
        
        return "public/schedule";
    }
}