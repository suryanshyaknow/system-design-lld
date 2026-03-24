package ParkingLot.strategy;

import ParkingLot.model.ParkingFloor;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Vehicle;

import java.util.*;

public interface SpotAllocationStrategy {

    /**
     * Finds AND atomically occupies a compatible spot.
     * Throws NoSpotAvailableException if none found.
     */
    ParkingSpot findAndOccupySpot(Vehicle vehicle, List<ParkingFloor> floorList);

}
