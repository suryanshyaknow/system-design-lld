package FactoryPattern.PaymentFactory.client;

import FactoryPattern.PaymentFactory.PaymentProcessor;
import FactoryPattern.PaymentFactory.factory.PaymentFactory;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        PaymentProcessor paymentProcessor = PaymentFactory.getPaymentProcessor("UPI");
        paymentProcessor.pay(2549);

        paymentProcessor = PaymentFactory.getPaymentProcessor("CGI");
        paymentProcessor.pay(2549);
    }
}
