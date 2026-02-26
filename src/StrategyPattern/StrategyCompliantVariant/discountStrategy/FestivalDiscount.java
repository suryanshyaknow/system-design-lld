package StrategyPattern.StrategyCompliantVariant.discountStrategy;

public class FestivalDiscount implements DiscountStrategy {

    @Override
    public double apply(double amount) {
        return amount * 0.8;
    }

}
