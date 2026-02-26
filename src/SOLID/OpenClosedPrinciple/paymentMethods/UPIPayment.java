package SOLID.OpenClosedPrinciple.paymentMethods;

import SOLID.OpenClosedPrinciple.PaymentMethod;

public class UPIPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying w UPI..");
    }

}
