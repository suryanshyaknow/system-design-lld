package FactoryPattern.PaymentFactory.client;

import FactoryPattern.PaymentFactory.implementations.PaymentProcessor;
import FactoryPattern.PaymentFactory.factory.PaymentFactory;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        PaymentProcessor paymentProcessor = PaymentFactory.getPaymentProcessor("UPI");
        paymentProcessor.pay(2549);

        paymentProcessor = PaymentFactory.getPaymentProcessor("CGI");
        paymentProcessor.pay(2549);

        // 1. Client here has a zero clue what class in being instantiated.
        // 2. Factory Pattern is about creating objects w/o exposing the creation logic to the client.
        // 3. It basically centralizes & abstracts all this shit.
    }
}
