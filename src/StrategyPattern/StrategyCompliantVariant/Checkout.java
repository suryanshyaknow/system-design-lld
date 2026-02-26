package StrategyPattern.StrategyCompliantVariant;

import StrategyPattern.StrategyCompliantVariant.discountStrategy.DiscountStrategy;

public class Checkout {

    private DiscountStrategy discountStrategy;

    Checkout(DiscountStrategy discountStrategy) { // Injection
        this.discountStrategy = discountStrategy;
    }

    void checkout(double amount) {
        double finalAmt = discountStrategy.apply(amount);
        System.out.println("Final: " + finalAmt);
    }

}
