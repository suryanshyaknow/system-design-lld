package StrategyPattern.StrategyCompliantVariant.discountStrategy.MoreStrategies;

import StrategyPattern.StrategyCompliantVariant.discountStrategy.DiscountStrategy;

public class ThresholdDiscount implements DiscountStrategy {

    private double thresh;

    public ThresholdDiscount(Double thresh) {
        this.thresh = thresh;
    }

    @Override
    public double apply(double amount) {
        return amount >= 5000 ? .7 * amount : amount;
    }

}
