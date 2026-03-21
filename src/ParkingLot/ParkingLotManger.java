package ParkingLot;

import ParkingLot.model.ParkingFloor;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Ticket;
import ParkingLot.model.Vehicle;
import ParkingLot.strategy.PricingStrategy;
import ParkingLot.strategy.SpotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ParkingLotManger {

    List<ParkingFloor> parkingFloors;
    HashMap<String, Ticket> activeTickets;
    // Since the current design is single instance and in-memory.
    // However, in a distributed setup, I'd mover shared state like activeTickets & spot availability
    // to a centralized store like Redis or db,w locking or atomic operations.


    // Some logic might change independently, so I'll abstract it behind interfaces
    PricingStrategy pricingStrategy;
    SpotAllocationStrategy spotAllocationStrategy;

    public Ticket parkVehicle(Vehicle vehicle) {
        // First off, see if a spot is available
        ParkingSpot spot = spotAllocationStrategy.findSpot(vehicle, parkingFloors);
        spot.isFree = false;

        // Generate a ticket
        Ticket ticket = new Ticket(vehicle.vehicleId, spot.spotId);
        activeTickets.put(ticket.ticketId, ticket);
        return ticket;
    }

    public Double unparkVehicleAndComputeCost(String ticketId) {
        // Retrieve the ticket from active tickets
        Ticket ticket = activeTickets.get(ticketId);
        LocalDateTime exitTime = LocalDateTime.now();

        // Compute the cost and free the spot
        double fee = pricingStrategy.compute(ticket, exitTime);
        freeSpot(ticket.spotId);
        activeTickets.remove(ticketId);
        return fee;
    }

    private void freeSpot(String spotId) {
        // Retrieve the spot and mark it free
    }

}
