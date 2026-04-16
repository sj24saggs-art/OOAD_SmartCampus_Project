package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/system")
    public String viewSystem(Model model) {
        var all = bookingRepository.findAll();
        model.addAttribute("allBookings", all);
        model.addAttribute("totalRequests", all.size());
        return "admin";
    }
}