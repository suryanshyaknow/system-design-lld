package ObserverPatttern.WalmartAmazonNotifyMe;

import ObserverPatttern.WalmartAmazonNotifyMe.Observable.IPhoneStockObservable;
import ObserverPatttern.WalmartAmazonNotifyMe.Observable.StockObservable;
import ObserverPatttern.WalmartAmazonNotifyMe.Observer.EmailAlertNotificationObserver;
import ObserverPatttern.WalmartAmazonNotifyMe.Observer.MobileAlertNotificationObserver;
import ObserverPatttern.WalmartAmazonNotifyMe.Observer.NotificationAlertObserver;

public class AmazonStore {

    public static void main(String[] args) {

        StockObservable iphoneStockObservable = new IPhoneStockObservable();

        NotificationAlertObserver observer1 = new EmailAlertNotificationObserver("suryansh@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertNotificationObserver("neo@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertNotificationObserver("suryanshyaknow", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
