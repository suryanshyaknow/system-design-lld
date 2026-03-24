package ParkingLot.strategy;

import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Ticket;

import java.time.LocalDateTime;

public interface PricingStrategy {

    double compute(Ticket ticket, ParkingSpot spot, LocalDateTime exitTime);
}
