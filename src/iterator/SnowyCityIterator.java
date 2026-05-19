package iterator;

import model.City;
import model.WeatherState;

import java.util.List;

public class SnowyCityIterator implements CityWeatherIterator {
    private List<City> cities;
    private int position;

    public SnowyCityIterator(List<City> cities) {
        this.cities = cities;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < cities.size()) {
            if (cities.get(position).getCurrentWeatherState() == WeatherState.SNOWY) {
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