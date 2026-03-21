package ParkingLot.model;

import java.time.LocalDateTime;

public class Ticket {

    public String ticketId;
    public String spotId; // Associated parking spot
    LocalDateTime entryTime;
    LocalDateTime exitTime; // It'll be populated at the end of ticket lifecycle

    public Ticket(String ticketId, String spotId) {
        this.ticketId = ticketId;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

}
