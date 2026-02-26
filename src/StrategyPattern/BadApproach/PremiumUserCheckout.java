package StrategyPattern.BadApproach;

public class PremiumUserCheckout extends Checkout {

    @Override
    double applyDiscount(double amount) {
        return amount * .7;
    }
}
