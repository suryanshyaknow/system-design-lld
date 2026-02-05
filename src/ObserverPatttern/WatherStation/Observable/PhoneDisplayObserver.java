package ObserverPatttern.WatherStation.Observable;

import ObserverPatttern.WatherStation.Subject.Subject;
import ObserverPatttern.WatherStation.Subject.WeatherStation;

public class PhoneDisplayObserver implements Observer {

    @Override
    public void update(Subject subject) {
        if (subject instanceof WeatherStation ws) {
            int temp = ws.getTemperature();
            System.out.println("Phone shows temp: " + temp);
        }

    }
}
