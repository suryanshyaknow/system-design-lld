package FactoryPattern.PaymentFactory.factory;

import FactoryPattern.PaymentFactory.implementations.PaymentProcessor;
import FactoryPattern.PaymentFactory.implementations.CreditCardPayment;
import FactoryPattern.PaymentFactory.implementations.PayPalPayment;
import FactoryPattern.PaymentFactory.implementations.UPIPayment;

public class PaymentFactory {

    public static PaymentProcessor getPaymentProcessor(String type) throws IllegalAccessException {
        return switch (type.toUpperCase()) {
            case "CARD" -> new CreditCardPayment();
            case "UPI" -> new UPIPayment();
            case "PAYPAL" -> new PayPalPayment();
            default -> throw new IllegalAccessException("Invalid Payment type");
        };

//        switch (type.toUpperCase()) {
//            case "CARD":
//                return new CreditCardPayment();
//            case "UPI":
//                return new UPIPayment();
//            case "PAYPAL":
//                return new PayPalPayment();
//            default:
//                throw new IllegalAccessException("Invalid Payment type");
    }
}
