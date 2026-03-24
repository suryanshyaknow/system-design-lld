package ParkingLot.strategy.impl;

import ParkingLot.enums.ParkingSpotType;
import ParkingLot.exception.NoSpotAvailableException;
import ParkingLot.model.ParkingFloor;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Vehicle;
import ParkingLot.strategy.SpotAllocationStrategy;
import ParkingLot.strategy.SpotTypeMapper;

import java.util.List;

/**
 * Allocates the first free spot of the correct type, scanning
 * floors in ascending order (nearest to entrance = floor 1).
 */
public class NearestSpotStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot findAndOccupySpot(Vehicle vehicle, List<ParkingFloor> floorList) {
        ParkingSpotType required = SpotTypeMapper.resolve(vehicle.getVehicleType());

        for (ParkingFloor parkingFloor : floorList) {
            for (ParkingSpot spot : parkingFloor.getFreeSpotsByType(required)) {
                // tryOccupy() is atomic — handles concurrent callers safely
                if (spot.tryOccupy()) return spot;
            }
        }

        // Else
        throw new NoSpotAvailableException(vehicle.getVehicleType().toString());
    }

}
