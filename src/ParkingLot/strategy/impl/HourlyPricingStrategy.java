package ParkingLot.strategy.impl;

import ParkingLot.enums.ParkingSpotType;
import ParkingLot.model.ParkingSpot;
import ParkingLot.model.Ticket;
import ParkingLot.strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class HourlyPricingStrategy implements PricingStrategy {

    // Rate per hour per spot type
    private static final Map<ParkingSpotType, Double> RATES = Map.of(
            ParkingSpotType.COMPACT, 20.0,
            ParkingSpotType.MEDIUM, 40.0,
            ParkingSpotType.LARGE, 60.0
    );

    @Override
    public double compute(Ticket ticket, ParkingSpot spot, LocalDateTime exitTime) {
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        double hours = Math.ceil(minutes / 60.0); // round up to the next hour
        double rate = RATES.getOrDefault(spot.getSpotType(), 40.0); // spot.getSpotType() — no second registry, spot already held by manager
        return hours * rate;
    }

}
