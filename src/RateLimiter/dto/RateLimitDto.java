package RateLimiter.dto;

public class RateLimitDto {

    private final boolean allowed;
    private final int remainingTokens;
    private final long retryAfterMs;

    public RateLimitDto(boolean allowed, int remainingTokens, long retryAfterMs) {
        this.allowed = allowed;
        this.remainingTokens = remainingTokens;
        this.retryAfterMs = retryAfterMs;
    }

    private boolean isAllowed() {
        return allowed;
    }

    private int getRemainingTokens() {
        return remainingTokens;
    }

    private long getRetryAfterMs() {
        return retryAfterMs;
    }

}
