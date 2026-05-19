package observer;

import java.util.List;
import model.City;

public class TemperatureObserver implements WeatherObserver {

    @Override
    public void update(List<City> cities) {
        System.out.println("\nSon sicaklik guncellemeleri:");

        for (City city : cities) {
            System.out.println(city.getName() + " : " + city.getCurrentTemperature() + " C");
        }
    }
}