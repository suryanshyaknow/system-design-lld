package ObserverPatttern.WalmartAmazonNotifyMe.Observer;

import ObserverPatttern.WalmartAmazonNotifyMe.Observable.StockObservable;

public class MobileAlertNotificationObserver implements NotificationAlertObserver {

    private String userName;
    public StockObservable stockObservable;

    public MobileAlertNotificationObserver(String userName, StockObservable stockObservable) {
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
         sendMessageOnMobile(userName, "Product's back in stock, hurry tf up!");
    }

    private void sendMessageOnMobile(String userName, String message) {
        System.out.println(message);
        // Send the message to the end user
    }
}
