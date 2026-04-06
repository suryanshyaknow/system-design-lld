package RateLimiter.strategy;

import RateLimiter.config.RateLimitConfig;

public interface RateLimitConfigProvider {

    RateLimitConfig getConfig(String clientKey);

}
