package SOLID.OpenClosedPrinciple;

import SOLID.OpenClosedPrinciple.paymentMethods.UPIPayment;
import SOLID.OpenClosedPrinciple.paymentMethods.WalletPayment;

public class PaymentService {

    PaymentMethod paymentMethod;
//    UPIPayment paymentMethod;
//    WalletPayment paymentMethod;


    void pay() {
        paymentMethod.pay();
    }

}
