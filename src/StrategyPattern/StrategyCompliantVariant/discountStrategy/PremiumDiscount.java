package StrategyPattern.StrategyCompliantVariant.discountStrategy;

public class PremiumDiscount implements DiscountStrategy {

    @Override
    public double apply(double amount) {
        return amount * 0.7;
    }

}
