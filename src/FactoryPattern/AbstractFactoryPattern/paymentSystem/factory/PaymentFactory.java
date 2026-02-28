package FactoryPattern.AbstractFactoryPattern.paymentSystem.factory;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.PaymentProcessor;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.RefundProcessor;

public interface PaymentFactory {

    PaymentProcessor createPaymentProcessor();

    RefundProcessor createRefundProcessor();

}
