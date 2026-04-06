package RateLimiter.strategy;

import RateLimiter.config.RateLimitConfig;

public class FlatConfigProvider implements RateLimitConfigProvider {

    private final RateLimitConfig rateLimitConfig;

    public FlatConfigProvider(RateLimitConfig rateLimitConfig) {
        this.rateLimitConfig = rateLimitConfig;
    }

    @Override
    public RateLimitConfig getConfig(String clientKey) {
        return rateLimitConfig;
    }

}
