package ParkingLot.model;

import java.time.LocalDateTime;

public class Ticket {

    private final String ticketId;
    private final String vehicleId;
    private final String spotId; // Associated parking spot
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime; // It'll be populated at the end of ticket lifecycle

    public Ticket(String ticketId, String vehicleId, String spotId) {
        this.ticketId = ticketId;
        this.vehicleId = vehicleId;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDateTime getEntryTime() {
        return this.entryTime;
    }

}
