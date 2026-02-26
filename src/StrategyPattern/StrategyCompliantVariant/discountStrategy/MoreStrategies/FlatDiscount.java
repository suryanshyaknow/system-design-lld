package StrategyPattern.StrategyCompliantVariant.discountStrategy.MoreStrategies;

import StrategyPattern.StrategyCompliantVariant.discountStrategy.DiscountStrategy;

public class FlatDiscount implements DiscountStrategy {

    private double flatAmount;

    FlatDiscount(double flatAmount) {
        this.flatAmount = flatAmount;
    }

    @Override
    public double apply(double amount) {
        return amount >= flatAmount ? amount - flatAmount : amount;
    }
}
