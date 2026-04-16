package com.smartcampus.facility_booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // ADD THIS BLOCK: It handles the initial page load
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This must match your login.html filename
    }

    // This handles the actual login button click
    @PostMapping("/login/auth")
    public String authenticate(@RequestParam String username, 
                               @RequestParam String password, 
                               @RequestParam String role, 
                               Model model) {
        
        if ("shivani".equalsIgnoreCase(username) && "ORGANIZER".equals(role)) {
            return "redirect:/organizer/dashboard";
        } else if ("shalmali".equalsIgnoreCase(username) && "MANAGER".equals(role)) {
            return "redirect:/manager/approvals";
        } else if ("roshini".equalsIgnoreCase(username) && "ADMIN".equals(role)) {
            return "redirect:/admin/system";
        } else if (("student".equalsIgnoreCase(username) || "teacher".equalsIgnoreCase(username)) 
                   && "VIEWER".equals(role)) {
            return "redirect:/public/events";
        }
        
        model.addAttribute("error", "Invalid Credentials or Role Selection.");
        return "login";
    }
}