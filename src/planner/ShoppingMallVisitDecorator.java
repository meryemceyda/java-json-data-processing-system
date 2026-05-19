package planner;

public class ShoppingMallVisitDecorator extends CityPlannerDecorator {

    public ShoppingMallVisitDecorator(CityPlanner cityPlanner) {
        super(cityPlanner);
    }

    @Override
    public String getDescription() {
        return cityPlanner.getDescription() + " + Shopping Mall Visit";
    }

    @Override
    public double getTotalCost() {
        return cityPlanner.getTotalCost() + 500;
    }

    @Override
    public double getTotalTimeHours() {
        return cityPlanner.getTotalTimeHours() + 3;
    }
}