package ParkingLot.exception;

public class NoSpotAvailableException extends RuntimeException {

    public NoSpotAvailableException(String vehicleType) {
        super("No spot available for vehicle type: " + vehicleType);
    }
}
