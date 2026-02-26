package StrategyPattern.BadApproach;

public class Checkout {

    void checkout(double amount) {
        double finalAmt = applyDiscount(amount);
        System.out.println("Final: " + finalAmt);
    }

    double applyDiscount(double amount) {
        return amount;
    }

    // Basically, an inheritance abuse.
    // Now see:
    // RegularCheckout
    // PremiumCheckout
    // FestivalRegularCheckout
    // FestivalPremiumCheckout
    // FlashPremiumCheckout
    // CouponFestivalPremiumCheckout
    //... Are these different types of checkout?
    // Nope. A checkout is still a checkout. Only discount logic is getting changed.
    // Which could be extracted into a strategy.

    // Strategy Pattern:
    // When multiple subclasses duplicate or slightly vary behavior that doesn't
    // conceptually belong to the base/parent class, we extract that behavior into
    // a strategy and let the parent delegate it via composition (has-a relationship).
    // Giving leeway to the child classes to use whatever strategy/logic they wanna
    // comply w.

}
