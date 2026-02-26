package StrategyPattern.BadApproach;

public class FestivalCheckout extends Checkout {

    @Override
    double applyDiscount(double amount) {
        return amount * 0.8;
    }

}
