package ObserverPatttern.WeatherStation.Subject;

import ObserverPatttern.WeatherStation.Observable.Observer;

public interface Subject {

    public void add(Observer observerObj);

    public void remove(Observer observerObj);

    public void notifyObservers();

    public void setTemperature(int temperature);

    Integer getTemperature();
}
