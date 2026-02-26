package StrategyPattern.StrategyCompliantVariant.discountStrategy.MoreStrategies;

import StrategyPattern.StrategyCompliantVariant.discountStrategy.DiscountStrategy;

public class CombinedDiscount implements DiscountStrategy {

    private DiscountStrategy first;
    private DiscountStrategy second;

    public CombinedDiscount(DiscountStrategy first, DiscountStrategy second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double apply(double amount) {
        double afterFirst = first.apply(amount);
        return second.apply(afterFirst);
    }

}
