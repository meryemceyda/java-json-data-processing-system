package planner;

public class ParkVisitDecorator extends CityPlannerDecorator {

    public ParkVisitDecorator(CityPlanner cityPlanner) {
        super(cityPlanner);
    }

    @Override
    public String getDescription() {
        return cityPlanner.getDescription() + " + Park Visit";
    }

    @Override
    public double getTotalCost() {
        return cityPlanner.getTotalCost() + 100;
    }

    @Override
    public double getTotalTimeHours() {
        return cityPlanner.getTotalTimeHours() + 1.5;
    }
}
