package ParkingLot.enums;

public enum ParkingSpotType {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String spotType;

    ParkingSpotType(String spotType) {
        this.spotType = spotType;
    }

    public String getType() {
        return this.spotType;
    }

}
