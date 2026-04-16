package com.smartcampus.facility_booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    /**
     * Authentication Logic: Validates user and role.
     * Satisfies Phase 1 functional requirements for secure login[cite: 8, 15].
     */

    @PostMapping("/auth")
    public String authenticate(@RequestParam String username, 
                           @RequestParam String password, 
                           @RequestParam String role, 
                           Model model) {

    // Logic for Shivani (Organizer)
    if ("shivani".equalsIgnoreCase(username) && "pesu123".equals(password) && "ORGANIZER".equals(role)) {
        return "redirect:/organizer/dashboard";
    }
    
    // Logic for Shalmali (Manager)
    else if ("shalmali".equalsIgnoreCase(username) && "manager789".equals(password) && "MANAGER".equals(role)) {
        return "redirect:/manager/approvals";
    }
    
    // Logic for Sai Roshini (Admin)
    else if ("roshini".equalsIgnoreCase(username) && "admin456".equals(password) && "ADMIN".equals(role)) {
        return "redirect:/admin/system";
    }
    
    // Fallback for failed authentication
    else {
        model.addAttribute("error", "Invalid Credentials or Role for this user.");
        return "login";
    }
    }
}