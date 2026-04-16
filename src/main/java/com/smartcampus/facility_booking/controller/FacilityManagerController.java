package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.service.FacilityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Shalmali V Ram's Module: Facility Manager
 * Implements MVC Architecture for the Approval System.
 */
@Controller
@RequestMapping("/manager")
public class FacilityManagerController {

    @Autowired
    private FacilityManagerService facilityManagerService;

    /**
     * View for Shalmali's module.
     * Passes only PENDING bookings to the manager.html template.
     */
    @GetMapping("/approvals")
    public String viewApprovals(Model model) {
        List<Booking> allBookings = facilityManagerService.getAllBookings();
        
        // Filter logic: Managers only process PENDING requests 
        List<Booking> pending = allBookings.stream()
            .filter(b -> b.getStatus() == Booking.BookingStatus.PENDING)
            .collect(Collectors.toList());

        model.addAttribute("pendingBookings", pending);
        return "manager"; // renders src/main/resources/templates/manager.html
    }

    /**
     * Handles Approval action from the Thymeleaf form.
     * Updates status in MySQL and redirects to refresh the queue.
     */
    @PostMapping("/approve/{id}")
    public String approveBooking(@PathVariable Long id) {
        facilityManagerService.approveBooking(id);
        return "redirect:/manager/approvals";
    }

    /**
     * Handles Rejection action.
     */
    @PostMapping("/reject/{id}")
    public String rejectBooking(@PathVariable Long id) {
        facilityManagerService.rejectBooking(id);
        return "redirect:/manager/approvals";
    }
}