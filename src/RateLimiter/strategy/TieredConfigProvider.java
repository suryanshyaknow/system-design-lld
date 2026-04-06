package RateLimiter.strategy;

import RateLimiter.config.RateLimitConfig;

import java.util.Map;

public class TieredConfigProvider implements RateLimitConfigProvider {

    private final Map<String, RateLimitConfig> tierConfigs;  // tier -> config
    private final Map<String, String> clientTiers;  // clientKey -> tier
    private final RateLimitConfig defaultConfig;

    public TieredConfigProvider(Map<String, RateLimitConfig> tierConfigs,
                                Map<String, String> clientTiers,
                                RateLimitConfig defaultConfig) {
        this.tierConfigs = tierConfigs;
        this.clientTiers = clientTiers;
        this.defaultConfig = defaultConfig;
    }

    @Override
    public RateLimitConfig getConfig(String clientKey) {
        String tier = clientTiers.getOrDefault(clientKey, "free");
        return tierConfigs.getOrDefault(tier, defaultConfig);
    }

}
