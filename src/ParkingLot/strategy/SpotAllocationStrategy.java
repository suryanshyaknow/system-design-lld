package ParkingLot.strategy;

import ParkingLot.model.ParkingFloor;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Vehicle;

import java.util.*;

public interface SpotAllocationStrategy {

    ParkingSpot findSpot(Vehicle vehicle, List<ParkingFloor> floorList);

}
