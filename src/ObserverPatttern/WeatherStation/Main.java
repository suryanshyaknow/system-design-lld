package ObserverPatttern.WeatherStation;

import ObserverPatttern.WeatherStation.Observable.PhoneDisplayObserver;
import ObserverPatttern.WeatherStation.Subject.WeatherStation;

public class Main {

    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        PhoneDisplayObserver phoneDisplayObserver = new PhoneDisplayObserver();

        ws.add(phoneDisplayObserver);
        ws.setTemperature(30); // It automatically notifies if there's a change in the temnperature

        ws.setTemperature(30); // It automatically notifies if there's a change in the temnperature
        ws.setTemperature(35); // It automatically notifies if there's a change in the temnperature
        ws.setTemperature(35); // It automatically notifies if there's a change in the temnperature
        ws.setTemperature(45); // It automatically notifies if there's a change in the temnperature

    }

}
