package FactoryPattern.AbstractFactoryPattern.paymentSystem.razorpay;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.PaymentProcessor;

public class RazorpayPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Razorpay payment of ₹" + amount);
    }

}
