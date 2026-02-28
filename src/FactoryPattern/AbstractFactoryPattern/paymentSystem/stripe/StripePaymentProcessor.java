package FactoryPattern.AbstractFactoryPattern.paymentSystem.stripe;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.PaymentProcessor;

public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Razorpay payment of $" + amount);
    }

}
