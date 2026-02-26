package SOLID.OpenClosedPrinciple.paymentMethods;

import SOLID.OpenClosedPrinciple.PaymentMethod;

public class WalletPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying w Wallet..");
    }

}
