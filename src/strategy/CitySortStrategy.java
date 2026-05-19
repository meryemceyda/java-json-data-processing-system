package strategy;

import model.City;
import java.util.List;

public interface CitySortStrategy {
    void sort(List<City> cities);
}