package RateLimiter.core;

import RateLimiter.config.RateLimitConfig;
import RateLimiter.dto.RateLimitDto;

public class TokenBucket {

    private final int capacity;
    private final double refillRate;
    private int tokens;
    private long lastRefillNanos; // in nanos

    public TokenBucket(RateLimitConfig rateLimitConfig) {
        this.capacity = rateLimitConfig.getCapacity();
        this.refillRate = rateLimitConfig.getRefillRate();
        this.tokens = capacity; // starting full
        this.lastRefillNanos = System.nanoTime();
    }

    /**
     * Atomically refill + attempt consume
     * `synchronized` ensures no two threads interleave refill and consume.
     *
     * @return
     */
    public synchronized RateLimitDto tryConsume() {
        refill();
        if (tokens >= 1.0) {
            tokens--;
            return new RateLimitDto(true, tokens, 0L);
        }

        // Otherwise compute the time to retry, i.e., how long until you have atleast one token available
        // refill rate = 5 tokens/sec
        // 5 token -> 1 sec
        // 1 token -> 1/5 * 1000
        long retryAfterMs = (long) ((1.0 - tokens) / refillRate * 1000);
        return new RateLimitDto(false, 0, retryAfterMs);
    }

    private void refill() {
        // refillRate, tokens, last time stamp
        double secsPassed = (double) (System.nanoTime() - lastRefillNanos) / 1_000_000_000;

        // 1s -> 5 tokens
        // xs -> 5 * x
        int tokensToRefill = (int) (refillRate * secsPassed);
        // Should not exceed capacity
        if (tokensToRefill > 0)
            tokens = Math.min(capacity, tokens + tokensToRefill);

        // Set last refill timestamp
        lastRefillNanos = System.nanoTime();
    }
}
