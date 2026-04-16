package com.smartcampus.facility_booking.controller;

import com.smartcampus.facility_booking.models.Booking;
import com.smartcampus.facility_booking.service.FacilityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manager")
public class FacilityManagerController {

    @Autowired
    private FacilityManagerService managerService;

    @GetMapping("/approvals")
    public String viewApprovals(Model model) {
        var pending = managerService.getAllBookings().stream()
            .filter(b -> b.getStatus() == Booking.BookingStatus.PENDING)
            .collect(Collectors.toList());
        model.addAttribute("pendingBookings", pending);
        return "manager";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        managerService.approveBooking(id);
        return "redirect:/manager/approvals";
    }

    @PostMapping("/reject/{id}")
    public String reject(@PathVariable Long id) {
        managerService.rejectBooking(id);
        return "redirect:/manager/approvals";
    }
}