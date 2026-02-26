package SOLID.OpenClosedPrinciple.paymentMethods;

import SOLID.OpenClosedPrinciple.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying w credit card..");
    }

}
