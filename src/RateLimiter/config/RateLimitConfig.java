package RateLimiter.config;

public class RateLimitConfig {

    private final int capacity; // max tokens a bucket can hold
    private final double refillRate; // tokens added per second

    public RateLimitConfig(int capacity, double refillRate) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be grater than 0.");
        if (refillRate <= 0) throw new IllegalArgumentException("RefillRate must be grater than 0.");
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRefillRate() {
        return refillRate;
    }

}
