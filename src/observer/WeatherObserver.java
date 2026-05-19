package observer;

import java.util.List;
import model.City;

public interface WeatherObserver {
    void update(List<City> cities);
}