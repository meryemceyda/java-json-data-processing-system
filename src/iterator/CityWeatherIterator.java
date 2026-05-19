package iterator;

import model.City;

public interface CityWeatherIterator {
    boolean hasNext();
    City next();
}