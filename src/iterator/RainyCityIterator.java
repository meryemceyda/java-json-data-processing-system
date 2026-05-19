package iterator;

import model.City;
import model.WeatherState;

import java.util.List;

public class RainyCityIterator implements CityWeatherIterator {
    private List<City> cities;
    private int position;

    public RainyCityIterator(List<City> cities) {
        this.cities = cities;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < cities.size()) {
            if (cities.get(position).getCurrentWeatherState() == WeatherState.RAINY) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public City next() {
        if (hasNext()) {
            return cities.get(position++);
        }
        return null;
    }
}