package ObserverPatttern.WeatherStation.Subject;

import ObserverPatttern.WeatherStation.Observable.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    List<Observer> observerList = new ArrayList<>();
    private int temperature;

    @Override
    public void add(Observer observerObj) {
        observerList.add(observerObj);
    }

    @Override
    public void remove(Observer observerObj) {
        observerList.remove(observerObj);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public void setTemperature(int temperature) {
        if (this.temperature == temperature)
            return;
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public Integer getTemperature() {
        return temperature;
    }
}
