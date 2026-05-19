package planner;

public class MuseumVisitDecorator extends CityPlannerDecorator {

    public MuseumVisitDecorator(CityPlanner cityPlanner) {
        super(cityPlanner);
    }

    @Override
    public String getDescription() {
        return cityPlanner.getDescription() + " + Museum Visit";
    }

    @Override
    public double getTotalCost() {
        return cityPlanner.getTotalCost() + 250;
    }

    @Override
    public double getTotalTimeHours() {
        return cityPlanner.getTotalTimeHours() + 2;
    }
}