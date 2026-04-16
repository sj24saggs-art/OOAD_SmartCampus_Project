package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.repository.BookingRepository;
import com.smartcampus.facility_booking.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Sai Roshini's Module: System Admin[cite: 51, 318].
 * Responsibility: System Analytics, Reports, and Global Oversight[cite: 21, 62].
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    /**
     * Admin Dashboard: Integrated Analytics and Global Oversight[cite: 62].
     * Satisfies MVC Pattern by returning the 'admin' view[cite: 27, 33].
     */
    @GetMapping("/system")
    public String viewSystemDashboard(Model model) {
        List<Booking> allBookings = bookingRepository.findAll();
        
        // Data for Analytics cards [cite: 21]
        model.addAttribute("allBookings", allBookings);
        model.addAttribute("totalRequests", bookingRepository.count());
        model.addAttribute("facilities", facilityRepository.findAll());
        
        // This returns templates/admin.html [cite: 33]
        return "admin"; 
    }

    /**
     * Minor Use Case: System Reports[cite: 21, 30].
     */
    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("totalBookings", bookingRepository.count());
        return "admin_reports"; 
    }
}