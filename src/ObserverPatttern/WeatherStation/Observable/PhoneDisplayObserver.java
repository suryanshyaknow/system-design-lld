package ObserverPatttern.WeatherStation.Observable;

import ObserverPatttern.WeatherStation.Subject.Subject;
import ObserverPatttern.WeatherStation.Subject.WeatherStation;

public class PhoneDisplayObserver implements Observer {

    @Override
    public void update(Subject subject) {
        if (subject instanceof WeatherStation ws) {
            int temp = ws.getTemperature();
            System.out.println("Phone shows temp: " + temp);
        }

    }
}
