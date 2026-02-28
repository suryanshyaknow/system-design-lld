package FactoryPattern.AbstractFactoryPattern.paymentSystem.factory;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.PaymentProcessor;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.RefundProcessor;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.razorpay.RazorpayPaymentProcessor;
import FactoryPattern.AbstractFactoryPattern.paymentSystem.stripe.StripeRefundProcessor;

public class RazorpayFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new RazorpayPaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new StripeRefundProcessor();
    }

}
