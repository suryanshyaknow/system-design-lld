package FactoryPattern.AbstractFactoryPattern.paymentSystem.razorpay;

import FactoryPattern.AbstractFactoryPattern.paymentSystem.interfaces.RefundProcessor;

public class RazorpayRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(double amount) {
        System.out.println("Processing Razorpay refund of ₹" + amount);
    }

}
