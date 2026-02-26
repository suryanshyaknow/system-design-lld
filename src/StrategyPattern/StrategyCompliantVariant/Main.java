package StrategyPattern.StrategyCompliantVariant;

import StrategyPattern.StrategyCompliantVariant.discountStrategy.FestivalDiscount;
import StrategyPattern.StrategyCompliantVariant.discountStrategy.PremiumDiscount;

public class Main {

    public static void main(String[] args) {
        Checkout festival = new Checkout(new FestivalDiscount());
        festival.checkout(1000);

        Checkout premiumUser = new Checkout(new PremiumDiscount());
        premiumUser.checkout(1000);
    }

}
