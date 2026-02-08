package ObserverPatttern.WeatherStation.Observable;

import ObserverPatttern.WeatherStation.Subject.Subject;

public interface Observer {

    public void update(Subject subject);

}
