package ObserverPatttern.WalmartAmazonNotifyMe.Observable;

import ObserverPatttern.WalmartAmazonNotifyMe.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable {

    List<NotificationAlertObserver> stockObserverList = new ArrayList<>(); // has-a relationship; composition
    private int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver stockObserverObj) {
        stockObserverList.add(stockObserverObj);
    }

    @Override
    public void remove(NotificationAlertObserver stockObserverObj) {
        stockObserverList.remove(stockObserverObj);
    }

    @Override
    public void notifySubscribers() {
        // Iterate over each subscriber and update
        for (NotificationAlertObserver subscriber : stockObserverList) {
            subscriber.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0) // Notify the users whenever new stock comes in post out-of-stock outage.
            notifySubscribers();
        this.stockCount = newStockCount;
    }

}
