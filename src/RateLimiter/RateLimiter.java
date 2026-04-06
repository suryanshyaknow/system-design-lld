package RateLimiter;

import RateLimiter.config.RateLimitConfig;
import RateLimiter.core.TokenBucket;
import RateLimiter.dto.RateLimitDto;
import RateLimiter.strategy.RateLimitConfigProvider;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Owns the bucket registry.
 * Delegates RateLimitConfig to the provider.
 * No Rate-limiting logic stays in here.
 */
public class RateLimiter {

    // _____________________ Singleton _______________________
    private static volatile RateLimiter instance;

    public static RateLimiter getInstance(RateLimitConfigProvider rateLimitConfigProvider) {
        if (instance == null) {
            synchronized (RateLimiter.class) {
                if (instance == null)
                    return new RateLimiter(rateLimitConfigProvider);
            }

        }
        return instance;
    }

    // ______________________ State ___________________________
    private final RateLimitConfigProvider rateLimitConfigProvider;
    private final Map<String, TokenBucket> buckets; // clientKey -> TokenBucket

    public RateLimiter(RateLimitConfigProvider rateLimitConfigProvider) {
        this.rateLimitConfigProvider = rateLimitConfigProvider;
        this.buckets = new ConcurrentHashMap<>();
    }

    // _____________________ Core API _________________________

    /**
     * Thread-safe entry point.
     * computeIfAbsent is atomic -- no two threads create a bucket for the same key.
     * tryConsume() is sync on the bucket -- no two threads consume the same token.
     */
    public RateLimitDto allowRequest(String clientKey) {
        // Fetch rate limiting info the for incoming key
        RateLimitConfig rateLimitConfig = rateLimitConfigProvider.getConfig(clientKey);
        TokenBucket tokenBucket = buckets.computeIfAbsent(clientKey, k -> new TokenBucket(rateLimitConfig));
        return tokenBucket.tryConsume();
    }


}
