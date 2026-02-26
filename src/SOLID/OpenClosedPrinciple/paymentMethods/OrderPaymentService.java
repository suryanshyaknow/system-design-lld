package SOLID.OpenClosedPrinciple.paymentMethods;

import SOLID.OpenClosedPrinciple.PaymentMethod;
import SOLID.OpenClosedPrinciple.PaymentService;

public class OrderPaymentService {

    private PaymentMethod paymentMethod;

    OrderPaymentService(PaymentMethod paymentMethod) { // Now the object is swa[[able for sub-types of Payment Method
        this.paymentMethod = paymentMethod;
    }

    void placeOrder() {
        paymentMethod.pay();

        // Note: Now, the high-level and low-level modules depend upon abstractions.
    }

}
