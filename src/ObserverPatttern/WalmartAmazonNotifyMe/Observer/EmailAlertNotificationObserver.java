package ObserverPatttern.WalmartAmazonNotifyMe.Observer;

import ObserverPatttern.WalmartAmazonNotifyMe.Observable.StockObservable;

public class EmailAlertNotificationObserver implements NotificationAlertObserver {

    private String userEmail;
    public StockObservable observable;

    public EmailAlertNotificationObserver(String userEmail, StockObservable observable) {
        this.userEmail = userEmail;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(userEmail, "Prod's back in store, hurry tf up!");
    }

    private void sendMail(String userEmail, String message) {
        System.out.println(userEmail + ": " + message);
        // Send actual mail to the user
    }
}
