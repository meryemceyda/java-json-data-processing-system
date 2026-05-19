package planner;

import model.City;

public class BasicCityPlanner implements CityPlanner {

    private City city;

    public BasicCityPlanner(City city) {
        this.city = city;
    }

    @Override
    public String getDescription() {
        return "Base plan for visiting " + city.getName();
    }

    @Override
    public double getTotalCost() {
        return 0;
    }

    @Override
    public double getTotalTimeHours() {
        return 0;
    }
}