package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;

@Controller
public class PublicEventsController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/public/events")
    public String viewPublicEvents(Model model) {
        // Minor Use Case: Filter and view only APPROVED events for the public
        var approvedEvents = bookingRepository.findAll().stream()
                .filter(b -> b.getStatus() == Booking.BookingStatus.APPROVED)
                .collect(Collectors.toList());
        
        model.addAttribute("events", approvedEvents);
        return "public_view";
    }
}