package ParkingLot.model;

import ParkingLot.enums.ParkingSpotType;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {

    private final int floorNumber; // Multi-floor
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = Collections.unmodifiableList(parkingSpots);
    }

    public List<ParkingSpot> getFreeSpotsByType(ParkingSpotType parkingSpotType) {
        return parkingSpots.stream()
                .filter(s -> s.getSpotType() == parkingSpotType && s.isFree())
                .collect(Collectors.toList());
    }

    // Getters
    public int getFloorNumber() {
        return this.floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

}
