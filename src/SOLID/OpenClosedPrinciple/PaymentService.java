package SOLID.OpenClosedPrinciple;

import SOLID.OpenClosedPrinciple.paymentMethods.UPIPayment;
import SOLID.OpenClosedPrinciple.paymentMethods.WalletPayment;

public class PaymentService {

    PaymentMethod paymentMethod = new UPIPayment(); // Closely coupled, should've been swappable

    void pay() {
        paymentMethod.pay();

        // Despite this adheres to Open/Close principle, but this
        // is a bad design as far as DIP is concerned.
        // Because, High-level module (PaymentService) is directly dependent upon
        // low-level module (PaymentMethod).
        // Check OrderPaymentService forDIP compliant version.
    }

}
