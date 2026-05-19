package observer;

import java.util.List;
import model.City;

public class WeatherStateObserver implements WeatherObserver {

    @Override
    public void update(List<City> cities) {
        System.out.println("\nSon hava durumu guncellemeleri:");

        for (City city : cities) {
            System.out.println(city.getName() + " : " + city.getCurrentWeatherState());
        }
    }
}