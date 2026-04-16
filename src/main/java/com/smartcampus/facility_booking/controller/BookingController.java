package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/organizer")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        model.addAttribute("bookings", bookingService.getMyBookings());
        return "organizer"; 
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking, RedirectAttributes ra) {
        String result = bookingService.requestBooking(booking);
        if (result.equals("CONFLICT")) {
            ra.addFlashAttribute("error", "Conflict Detected: This facility is already booked during these timings.");
        } else {
            ra.addFlashAttribute("success", "Booking request submitted successfully!");
        }
        return "redirect:/organizer/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/organizer/dashboard";
    }
}