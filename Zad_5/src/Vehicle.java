import java.awt.*;

public class Vehicle {
    final int id;
    final int speed;
    String name;
    String registrationNumber;
    District district = null;
    Street street;
    Point vehiclePosition;
    Crossroad fromCrossroad;
    Crossroad toCrossroad;

    public Vehicle(int id, String name, String registrationNumber, int speed, City parentCity) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.speed = speed;
        this.street = parentCity.streets.get(0);
        this.fromCrossroad = parentCity.crossroads.get(0);
        this.toCrossroad = parentCity.crossroads.get(1);
        this.vehiclePosition = new Point(parentCity.crossroads.get(0).crossroadPoint.x, parentCity.crossroads.get(0).crossroadPoint.y);
    }

    public void ride() {
        double distance = fromCrossroad.crossroadPoint.distance(toCrossroad.crossroadPoint);
        double time = distance / speed;
        double x = (toCrossroad.crossroadPoint.getX() - fromCrossroad.crossroadPoint.getX()) / time;
        double y = (toCrossroad.crossroadPoint.getY() - fromCrossroad.crossroadPoint.getY()) / time;
        double distanceLeft = distance;
        while (distanceLeft > 0.1) {
            distanceLeft = vehiclePosition.distance(toCrossroad.crossroadPoint);
            distanceLeft -= speed / 10d;
            vehiclePosition.setLocation(vehiclePosition.getX() + x, vehiclePosition.getY() + y);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        vehiclePosition.setLocation(toCrossroad.crossroadPoint.getX(), toCrossroad.crossroadPoint.getY());

        fromCrossroad = toCrossroad;
        street.removeVehicle(this);
        street = goToAnotherStreet();
        street.addVehicle(this);
        district = street.district;
        toCrossroad = street.getToCrossroad(fromCrossroad);
        ride();
    }

    private Street goToAnotherStreet() {
        Street chosenStreet = null;
        int minVehicleCount = Integer.MAX_VALUE;

        for (Street street : fromCrossroad.streets) {
            if (!street.equals(this.street) && street.vehicles.size() <= minVehicleCount) {
                chosenStreet = street;
                minVehicleCount = street.vehicles.size();
            }
        }

        return chosenStreet;
    }


    private void returnPosition() {
        if (vehiclePosition.distance(toCrossroad.crossroadPoint) < 0.1) {
            System.out.println("Samochód " + id + " dotarł do celu");
            System.out.println("Pozycja samochodu " + id + " to " + vehiclePosition.getX() + " " + vehiclePosition.getY());
        }
        System.out.println(vehiclePosition.getX() + " " + vehiclePosition.getY() + " " + street.name + " jadę do " + toCrossroad.name + " z " + fromCrossroad.name);
    }

    public void vehicleInfo() {
        if (district== null)
            System.out.println("Samochód " + id + " " + name + " " + registrationNumber + " " + speed);
        else
            System.out.println("Samochód " + id + " " + name + " " + registrationNumber + " " + speed + " " + district.name);
        System.out.println("Jedzie z " + fromCrossroad.name + " do " + toCrossroad.name + " po ulicy " + street.name);
        System.out.println("Pozycja samochodu to " + vehiclePosition.getX() + " " + vehiclePosition.getY());
    }
}
