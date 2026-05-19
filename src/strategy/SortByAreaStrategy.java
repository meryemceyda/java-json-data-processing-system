package strategy;

import model.City;
import java.util.List;
import java.util.Comparator;

public class SortByAreaStrategy implements CitySortStrategy {

    @Override
    public void sort(List<City> cities) {
        cities.sort(Comparator.comparingDouble(City::getArea));
    }
}