package ParkingLot.model;

import ParkingLot.enums.ParkingSpotType;

import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpot {

    private final String spotId;
    private final ParkingSpotType spotType;
    private volatile boolean isFree = true;
    // As the name suggests, this field is subject to change via thread,
    // and every read/write goes to the main memory.
    // No caching.

    private final ReentrantLock lock = new ReentrantLock();
    // NOTE: ReentrantLock + volatile ensures that multiple threads can safely occupy/free spots.

    public ParkingSpot(String spotId, ParkingSpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    /**
     * Atomically attempt to occupy this spot.
     * Returns true if successfully occupied, false if already taken.
     */
    public boolean tryOccupy() {
        lock.lock();
        try {
            if (!isFree) return false;
            isFree = false; // Occupy the spot if available
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void free() {
        lock.lock();
        try {
            isFree = true;
        } finally {
            lock.unlock();
        }
    }

    // Getters
    public boolean isFree() {
        return isFree;
    }

    public String getSpotId() {
        return this.spotId;
    }

    public ParkingSpotType getSpotType() {
        return this.spotType;
    }

}
