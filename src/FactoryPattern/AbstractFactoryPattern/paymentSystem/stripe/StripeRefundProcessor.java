package FactoryPattern.AbstractFactoryPattern.paymentSystem.stripe;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.RefundProcessor;

public class StripeRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(double amount) {
        System.out.println("Processing Stripe refund of $" + amount);
    }

}
