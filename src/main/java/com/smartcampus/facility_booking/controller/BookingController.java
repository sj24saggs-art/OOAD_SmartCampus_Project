package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.models.MaintenanceRequest;
import com.smartcampus.facility_booking.repository.MaintenanceRequestRepository;
import com.smartcampus.facility_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Shivani's Use Case: Event Organizer Module[cite: 35, 44].
 * Satisfies MVC Architecture Pattern.
 */
@Controller
@RequestMapping("/organizer")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MaintenanceRequestRepository maintenanceRepo;

    /**
     * Renders the Organizer Dashboard (The 'View' in MVC).
     */
    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        List<Booking> myBookings = bookingService.getMyBookings();
        // Passing data to the 'Model' so Thymeleaf can display it[cite: 11, 27].
        model.addAttribute("bookings", myBookings);
        // Returns the organizer.html template.
        return "organizer"; 
    }

    /**
     * Handles new booking requests via Form submission[cite: 17].
     * Uses @ModelAttribute for traditional MVC form binding.
     */
    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking) {
        bookingService.requestBooking(booking);
        // Standard MVC: Redirect back to dashboard to see updated records[cite: 12].
        return "redirect:/organizer/dashboard";
    }

    /**
     * Handles booking cancellation.
     */
    @PostMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "redirect:/organizer/dashboard";
    }

    /**
     * Individual Use Case requirement: Maintenance Reporting[cite: 30].
     */
    @PostMapping("/maintenance/report")
    public String reportIssue(@ModelAttribute MaintenanceRequest request) {
        maintenanceRepo.save(request);
        return "redirect:/organizer/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        // MVC Redirect: Refreshes the view to show the event is removed
        return "redirect:/organizer/dashboard";
}
}