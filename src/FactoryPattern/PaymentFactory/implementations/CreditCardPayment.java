package FactoryPattern.PaymentFactory.implementations;

import FactoryPattern.PaymentFactory.PaymentProcessor;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }

}
