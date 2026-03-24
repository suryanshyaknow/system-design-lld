package ParkingLot.strategy;

import ParkingLot.enums.ParkingSpotType;
import ParkingLot.enums.VehicleType;

import java.util.*;

public class SpotTypeMapper {

    // Centralizes compatibility logic so both strategies and the manager share the same truth

    private static final Map<VehicleType, ParkingSpotType> MAP = Map.of(
            VehicleType.TWO_WHEELER, ParkingSpotType.COMPACT,
            VehicleType.FOUR_WHEELER, ParkingSpotType.MEDIUM,
            VehicleType.UTILITY_TRUCK, ParkingSpotType.LARGE
    );

    public static ParkingSpotType resolve(VehicleType vehicleType) {
        ParkingSpotType spotType = MAP.get(vehicleType);
        if (spotType == null) throw new IllegalArgumentException("Unknown Vehicle Type: " + vehicleType);
        return spotType;
    }


}
