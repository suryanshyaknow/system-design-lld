package FactoryPattern.PaymentFactory.implementations;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }

}
