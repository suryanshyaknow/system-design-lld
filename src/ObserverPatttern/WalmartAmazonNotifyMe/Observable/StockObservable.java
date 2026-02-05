package ObserverPatttern.WalmartAmazonNotifyMe.Observable;

import ObserverPatttern.WalmartAmazonNotifyMe.Observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver stockObserverObj);

    public void remove(NotificationAlertObserver stockObserverObj);

    public void notifySubscribers();

    public void setStockCount(int stockCount);

}
