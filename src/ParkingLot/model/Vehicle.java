package ParkingLot.model;

import ParkingLot.enums.VehicleType;

public class Vehicle {

    private final String vehicleId;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    // Getters
    public String getVehicleId() {
        return this.vehicleId;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }


}
