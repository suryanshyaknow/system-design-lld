package FactoryPattern.PaymentFactory.implementations;

import FactoryPattern.PaymentFactory.PaymentProcessor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }

}
