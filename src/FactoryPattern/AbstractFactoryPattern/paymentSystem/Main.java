package FactoryPattern.AbstractFactoryPattern.paymentSystem;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.factory.PaymentFactory;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.factory.StripeFactory;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.PaymentProcessor;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.RefundProcessor;

public class Main {

    public static void main(String[] args) {

        // Choose family
        PaymentFactory factory = new StripeFactory();
        // PaymentFactory factory = new RazorpayFactory();

        PaymentProcessor paymentProcessor = factory.createPaymentProcessor();
        RefundProcessor refundProcessor = factory.createRefundProcessor();

        paymentProcessor.processPayment(1000);
        refundProcessor.processRefund(200);
    }

}
