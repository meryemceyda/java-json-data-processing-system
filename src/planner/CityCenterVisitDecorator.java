package planner;

public class CityCenterVisitDecorator extends CityPlannerDecorator {

    public CityCenterVisitDecorator(CityPlanner cityPlanner) {
        super(cityPlanner);
    }

    @Override
    public String getDescription() {
        return cityPlanner.getDescription() + " + City Center Visit";
    }

    @Override
    public double getTotalCost() {
        return cityPlanner.getTotalCost() + 150;
    }

    @Override
    public double getTotalTimeHours() {
        return cityPlanner.getTotalTimeHours() + 2.5;
    }
}