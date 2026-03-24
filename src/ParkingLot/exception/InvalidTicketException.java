package ParkingLot.exception;

public class InvalidTicketException extends RuntimeException {

    public InvalidTicketException(String ticketId) {
        super("Ticket not found or already closed: " + ticketId);
    }
}
