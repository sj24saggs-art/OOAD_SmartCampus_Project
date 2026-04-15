package service;

import model.Booking;

public class ApprovalService {

    public void approveBooking(Booking booking) {
        booking.setStatus("Approved");
        System.out.println("Booking " + booking.getBookingId() + " approved.");
    }

    public void rejectBooking(Booking booking) {
        booking.setStatus("Rejected");
        System.out.println("Booking " + booking.getBookingId() + " rejected.");
    }
}