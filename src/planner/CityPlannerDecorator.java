package planner;

public abstract class CityPlannerDecorator implements CityPlanner {

    protected CityPlanner cityPlanner;

    public CityPlannerDecorator(CityPlanner cityPlanner) {
        this.cityPlanner = cityPlanner;
    }

    @Override
    public String getDescription() {
        return cityPlanner.getDescription();
    }

    @Override
    public double getTotalCost() {
        return cityPlanner.getTotalCost();
    }

    @Override
    public double getTotalTimeHours() {
        return cityPlanner.getTotalTimeHours();
    }
}