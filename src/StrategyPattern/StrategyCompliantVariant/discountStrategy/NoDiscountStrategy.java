package StrategyPattern.StrategyCompliantVariant.discountStrategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double apply(double amount) {
        return amount;
    }
}
