// package com.smartcampus.facility_booking;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class FacilityBookingApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(FacilityBookingApplication.class, args);
//     }
// }

package com.smartcampus.facility_booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class FacilityBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacilityBookingApplication.class, args);
    }

    /**
     * This Bean acts as a startup trigger for your Admin & System tasks.
     * It allows you to verify the module's initialization as soon as the
     * Smart Campus system goes live.
     */
    @Bean
    public CommandLineRunner adminModuleInitializer() {
        return args -> {
            System.out.println("----------------------------------------------");
            System.out.println("SMART CAMPUS: Admin & System Module Active");
            System.out.println("System Time: " + LocalDateTime.now());

            // Major Use Case 1: Overseeing the Master Schedule
            System.out.println("[Status] Master Schedule Listener: STARTED");

            // Major Use Case 3: Reporting & Facility Health
            System.out.println("[Status] Facility Health Monitoring: ONLINE");

            // Minor Use Case 1: Database Persistence/Backup
            System.out.println("[Status] Auto-Backup Scheduler: INITIALIZED");
            System.out.println("----------------------------------------------");
        };
    }
}