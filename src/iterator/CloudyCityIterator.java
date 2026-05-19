package iterator;

import model.City;
import model.WeatherState;

import java.util.List;

public class CloudyCityIterator implements CityWeatherIterator {
    private List<City> cities;
    private int position;

    public CloudyCityIterator(List<City> cities) {
        this.cities = cities;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < cities.size()) {
            if (cities.get(position).getCurrentWeatherState() == WeatherState.CLOUDY) {
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