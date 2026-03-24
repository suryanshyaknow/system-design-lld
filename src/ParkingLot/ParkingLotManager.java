package ParkingLot;

import ParkingLot.exception.InvalidTicketException;
import ParkingLot.model.ParkingFloor;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Ticket;
import ParkingLot.model.Vehicle;
import ParkingLot.strategy.PricingStrategy;
import ParkingLot.strategy.SpotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotManager {

    // Singleton
    private static volatile ParkingLotManager instance; // Enforcing a single instance

    public static ParkingLotManager getInstance(
            List<ParkingFloor> floors,
            SpotAllocationStrategy spotAllocationStrategy,
            PricingStrategy pricingStrategy
    ) {
        // Can't just simply do new ParkingLotManager() directly
        if (instance == null) {
            synchronized (ParkingLotManager.class) {
                if (instance == null) {
                    instance = new ParkingLotManager(floors, spotAllocationStrategy, pricingStrategy);
                }
            }
        }
        return instance;
    }

    // ── State ────────────────────────────────────────────────────────────
    private final List<ParkingFloor> parkingFloors;
    private final Map<String, Ticket> activeTickets; // ticketId -> Ticket
    private final Map<String, ParkingSpot> spotRegistry; // spotId -> ParkingSpot
    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;

    // Since the current design is single instance and in-memory.
    // However, in a distributed setup, I'd move shared state like activeTickets & spot availability
    // to a centralized store like Redis or db, w locking or atomic operations.

    // ConcurrentHashMap handles thread safety within one JVM. If we needed to scale horizontally
    // — multiple instances behind a load balancer — I'd move activeTickets and spot state to Redis,
    // replace tryOccupy() with a SET NX, and activeTickets.remove() with GETDEL.
    // The strategy interfaces stay untouched — only the state layer changes.


    // Some logic might change independently, so I'll abstract it behind interfaces
    private ParkingLotManager(List<ParkingFloor> floors, SpotAllocationStrategy spotAllocationStrategy, PricingStrategy pricingStrategy) {
        this.parkingFloors = floors;
        this.allocationStrategy = spotAllocationStrategy;
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new ConcurrentHashMap<>(); // Thread-safe hashMap
        this.spotRegistry = buildSpotRegistry(floors);
    }

    private Map<String, ParkingSpot> buildSpotRegistry(List<ParkingFloor> floors) {
        Map<String, ParkingSpot> spotRegistry = new HashMap<>();
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                spotRegistry.put(spot.getSpotId(), spot);
            }
        }
        return spotRegistry;
    }

    // ── Core API ─────────────────────────────────────────────────────────

    public Ticket parkVehicle(Vehicle vehicle) {
        // First off, see if a spot is available
        ParkingSpot spot = allocationStrategy.findAndOccupySpot(vehicle, parkingFloors);

        // Generate a ticket
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle.getVehicleId(), spot.getSpotId());
        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    public Double unparkVehicle(String ticketId) {
        // Retrieve the ticket from active tickets
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new InvalidTicketException(ticketId);

        // Compute the cost and free the spot
        LocalDateTime exitTime = LocalDateTime.now();
        ParkingSpot spot = spotRegistry.get(ticket.getSpotId());
        double fee = pricingStrategy.compute(ticket, spot, exitTime);
        spot.free();
        return fee;
    }

}
