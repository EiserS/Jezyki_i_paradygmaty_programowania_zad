import java.util.ArrayList;

public class Street {
    String name;
    double length;
    final ArrayList<Crossroad> crossroads = new ArrayList<>();
    final ArrayList<Vehicle> vehicles = new ArrayList<>();
    District district;
    public Street(String name, Crossroad crossroads1, Crossroad crossroads2,District districts) {
        this.name = name;
        this.length = crossroads1.crossroadPoint.distance(crossroads2.crossroadPoint);
        this.crossroads.add(crossroads1);
        this.crossroads.add(crossroads2);
        this.district = districts;
    }

    public Crossroad getToCrossroad(Crossroad fromCrossroad) {
        if (fromCrossroad.equals(crossroads.get(0))) {
            return crossroads.get(1);
        } else {
            return crossroads.get(0);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
