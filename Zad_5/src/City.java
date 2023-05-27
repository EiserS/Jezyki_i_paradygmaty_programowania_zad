import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class City extends JFrame {
    Scanner scanner = new Scanner(System.in);

    public City() {
        super("City");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1500, 1500);
        setVisible(true);
    }

    ArrayList<District> districts = new ArrayList<>();
    ArrayList<Street> streets = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Crossroad> crossroads = new ArrayList<>();
    public void addStreet(Street street) {
        streets.add(street);
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void addCrossroad(Crossroad crossroad) {
        crossroads.add(crossroad);
    }
    private void addDistrict(District district) {
        districts.add(district);
    }
    public void loadCity() {
        addDistrict(new District(1, "Stare miasto"));//Szary
        addDistrict(new District(2, "Nowe miasto"));//Zielony
        addDistrict(new District(3, "Młynek"));//Cyjan
        addCrossroad(new Crossroad(1, 50, 50, "0"));
        addCrossroad(new Crossroad(2, 50, 150, "1"));
        addCrossroad(new Crossroad(3, 150, 50, "2"));
        addCrossroad(new Crossroad(4, 150, 150, "3"));
        addCrossroad(new Crossroad(5, 250, 150, "4"));
        addCrossroad(new Crossroad(6, 250, 50, "5"));
        addCrossroad(new Crossroad(7, 350, 50, "6"));
        addCrossroad(new Crossroad(8, 350, 150, "7"));
        addCrossroad(new Crossroad(9, 450, 50, "8"));
        addCrossroad(new Crossroad(10, 450, 150, "9"));
        addCrossroad(new Crossroad(11, 50, 250, "10"));
        addCrossroad(new Crossroad(12, 150, 250, "11"));
        addCrossroad(new Crossroad(13, 250, 250, "12"));
        addCrossroad(new Crossroad(14, 350, 250, "13"));
        addCrossroad(new Crossroad(15, 450, 250, "14"));
        addCrossroad(new Crossroad(16, 50, 350, "15"));
        addCrossroad(new Crossroad(17, 150, 350, "16"));
        addCrossroad(new Crossroad(18, 250, 350, "17"));
        addCrossroad(new Crossroad(19, 350, 350, "18"));
        addCrossroad(new Crossroad(20, 450, 350, "19"));
        addStreet(new Street("1", crossroads.get(0), crossroads.get(1), districts.get(1)));
        addStreet(new Street("2", crossroads.get(0), crossroads.get(2), districts.get(1)));
        addStreet(new Street("3", crossroads.get(1), crossroads.get(3), districts.get(1)));
        addStreet(new Street("4", crossroads.get(2), crossroads.get(3), districts.get(1)));
        addStreet(new Street("5", crossroads.get(3), crossroads.get(4), districts.get(2)));
        addStreet(new Street("6", crossroads.get(3), crossroads.get(5), districts.get(2)));
        addStreet(new Street("7", crossroads.get(4), crossroads.get(6), districts.get(2)));
        addStreet(new Street("8", crossroads.get(5), crossroads.get(6), districts.get(2)));
        addStreet(new Street("9", crossroads.get(6), crossroads.get(7), districts.get(0)));
        addStreet(new Street("10", crossroads.get(7), crossroads.get(8), districts.get(0)));
        addStreet(new Street("11", crossroads.get(7), crossroads.get(9), districts.get(0)));
        addStreet(new Street("12", crossroads.get(8), crossroads.get(9), districts.get(0)));
        addStreet(new Street("13", crossroads.get(9), crossroads.get(14), districts.get(2)));
        addStreet(new Street("14", crossroads.get(8), crossroads.get(6), districts.get(0)));
        addStreet(new Street("15", crossroads.get(7), crossroads.get(12), districts.get(2)));
        addStreet(new Street("16", crossroads.get(12), crossroads.get(13), districts.get(2)));
        addStreet(new Street("17", crossroads.get(13), crossroads.get(14), districts.get(2)));
        addStreet(new Street("18", crossroads.get(14), crossroads.get(19), districts.get(2)));
        addStreet(new Street("19", crossroads.get(14), crossroads.get(18), districts.get(2)));
        addStreet(new Street("20", crossroads.get(18), crossroads.get(12), districts.get(2)));
        addStreet(new Street("21", crossroads.get(12), crossroads.get(17), districts.get(1)));
        addStreet(new Street("22", crossroads.get(17), crossroads.get(18), districts.get(2)));
        addStreet(new Street("23", crossroads.get(3), crossroads.get(12), districts.get(1)));
        addStreet(new Street("24", crossroads.get(12), crossroads.get(4), districts.get(1)));
        addStreet(new Street("25", crossroads.get(15), crossroads.get(11), districts.get(1)));
        addStreet(new Street("26", crossroads.get(11), crossroads.get(16), districts.get(1)));
        addStreet(new Street("27", crossroads.get(16), crossroads.get(17), districts.get(1)));
        addStreet(new Street("28", crossroads.get(15), crossroads.get(10), districts.get(1)));
        addStreet(new Street("29", crossroads.get(10), crossroads.get(1), districts.get(1)));
        addStreet(new Street("30", crossroads.get(18), crossroads.get(19), districts.get(2)));
        addStreet(new Street("31", crossroads.get(11), crossroads.get(3), districts.get(2)));
        addStreet(new Street("32", crossroads.get(2), crossroads.get(5), districts.get(2)));


        for (Crossroad crossroad : crossroads) {
            for (Street street : streets) {
                if (street.crossroads.contains(crossroad)) {
                    crossroad.streets.add(street);
                }
            }
        }
        addVehicle(new Vehicle(1, "Ford", "GMB0094", 2, this));
        addVehicle(new Vehicle(2, "Toyota", "ZSZ8867", 1, this));
        addVehicle(new Vehicle(3, "BMW", "ONA6937", 2, this));
        addVehicle(new Vehicle(4, "Audi", "ESI7637", 1, this));
        addVehicle(new Vehicle(5, "Mercedes", "FGW8644", 2, this));
        addVehicle(new Vehicle(6, "Opel", "ZSL9058", 2, this));
        addVehicle(new Vehicle(7, "Volkswagen", "GA89043", 2, this));
        addVehicle(new Vehicle(8, "Fiat", "GSZ2429", 1, this));
        addVehicle(new Vehicle(9, "Renault", "LC10651", 1, this));
        addVehicle(new Vehicle(10, "Peugeot", "WPZ0099", 2, this));
        addVehicle(new Vehicle(11, "Citroen", "SL68298", 2, this));
        addVehicle(new Vehicle(12, "Nissan", "TKI8965", 2, this));
        addVehicle(new Vehicle(13, "Hyundai", "FSL2708", 1, this));
        addVehicle(new Vehicle(14, "Ford", "WS71196", 2, this));
        addVehicle(new Vehicle(15, "Toyota", "PN63399", 1, this));
        addVehicle(new Vehicle(16, "BMW", "NO38472", 2, this));
        addVehicle(new Vehicle(17, "Audi", "PTU9895", 2, this));
        addVehicle(new Vehicle(18, "Mercedes", "KDA5642", 2, this));
        addVehicle(new Vehicle(19, "Opel", "EPA6008", 1, this));
        addVehicle(new Vehicle(20, "Volkswagen", "ELE0784", 1, this));
        addVehicle(new Vehicle(21, "Fiat", "DLU4495", 2, this));
        addVehicle(new Vehicle(22, "Renault", "ZSL4343", 2, this));
        districts.get(0).streets.add(streets.get(10));
        districts.get(0).streets.add(streets.get(11));
        districts.get(0).streets.add(streets.get(9));
        districts.get(0).streets.add(streets.get(8));
        districts.get(0).streets.add(streets.get(13));
        districts.get(1).streets.add(streets.get(23));
        districts.get(1).streets.add(streets.get(4));
        districts.get(1).streets.add(streets.get(14));
        districts.get(1).streets.add(streets.get(7));
        districts.get(1).streets.add(streets.get(6));
        districts.get(1).streets.add(streets.get(5));
        districts.get(1).streets.add(streets.get(15));
        districts.get(1).streets.add(streets.get(16));
        districts.get(1).streets.add(streets.get(17));
        districts.get(1).streets.add(streets.get(18));
        districts.get(1).streets.add(streets.get(19));
        districts.get(1).streets.add(streets.get(31));
        districts.get(1).streets.add(streets.get(21));
        districts.get(1).streets.add(streets.get(29));
        districts.get(2).streets.add(streets.get(20));
        districts.get(2).streets.add(streets.get(22));
        districts.get(2).streets.add(streets.get(30));
        districts.get(2).streets.add(streets.get(28));
        districts.get(2).streets.add(streets.get(27));
        districts.get(2).streets.add(streets.get(26));
        districts.get(2).streets.add(streets.get(25));
        districts.get(2).streets.add(streets.get(3));
        districts.get(2).streets.add(streets.get(2));
        districts.get(2).streets.add(streets.get(1));
        districts.get(2).streets.add(streets.get(0));
        districts.get(2).streets.add(streets.get(24));
        districts.get(1).streets.add(streets.get(12));


    }


    public void startSimulation() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();

        for (Vehicle vehicle : vehicles) {
            Thread vehicleThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    vehicle.ride();
                }
            });
            vehicleThread.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int scale = 2;

        for (Street street : streets) {
            g.setColor(Color.BLUE);
            g.drawString(
                    street.name,
                    (street.crossroads.get(0).crossroadPoint.x + street.crossroads.get(1).crossroadPoint.x) / 2 * scale,
                    (street.crossroads.get(0).crossroadPoint.y + street.crossroads.get(1).crossroadPoint.y) / 2 * scale);
        }

        for (Crossroad crossroad : crossroads) {
            g.drawString(
                    crossroad.name,
                    crossroad.crossroadPoint.x * scale,
                    crossroad.crossroadPoint.y * scale
            );
        }
        for (District district : districts) {
            for (Street street : district.streets) {
                if (district.id == 3)
                    g.setColor(Color.CYAN);
                else if (district.id == 2)
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.LIGHT_GRAY);
                g.drawLine(
                        street.crossroads.get(0).crossroadPoint.x * scale,
                        street.crossroads.get(0).crossroadPoint.y * scale,
                        street.crossroads.get(1).crossroadPoint.x * scale,
                        street.crossroads.get(1).crossroadPoint.y * scale
                );
            }
        }
        g.setColor(Color.RED);
        for (Vehicle vehicle : vehicles) {
            g.drawString(
                    vehicle.name,
                    vehicle.vehiclePosition.getLocation().x * scale,
                    vehicle.vehiclePosition.getLocation().y * scale
            );
        }
    }

    public void showDistrictList() {
        System.out.println("Lista dzielnic");
        for (District district : districts) {
            System.out.println(district.id + " " + district.name);
        }
    }

    public void showCarListByDistrict() {
        showDistrictList();
        System.out.println("Podaj numer dzielnicy");
        int districtId = scanner.nextInt();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.district.id == districtId) {
                System.out.println(vehicle.name);
            }
        }
    }

    public void showAllCars() {
        System.out.println("Wszystkie samochody");
        for (Vehicle vehicle : vehicles) {
            vehicle.vehicleInfo();
            System.out.println("-----------");
        }
    }


    public void showCarInfoByRegistrationNumber() {
        System.out.println("Podaj numer rejestracyjny");
        String registrationNumber = scanner.nextLine();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.registrationNumber.equals(registrationNumber)) {
                vehicle.vehicleInfo();
            }
        }
    }

    public void showMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Menu:");
            System.out.println("1. Car Menu");
            System.out.println("2. Street Menu");
            System.out.println("3. District Menu");
            System.out.println("4. Exit");
            int userChose = scanner.nextInt();
            switch (userChose) {
                case 1 -> carMenu() ;
                case 2 -> streetMenu();
                case 3 -> districtMenu();
                case 4 -> shouldContinue = false;
                default -> System.out.println("Zły Znak");
            }
        }

    }

    private void districtMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("District Menu:");
            System.out.println("1. Show District");
            System.out.println("2. Show Streets in district");
            System.out.println("3. Show Cars in district");
            System.out.println("4. Show the most popular district");
            System.out.println("5. Show the less popular district");
            System.out.println("6. Show the most popular street in district");
            System.out.println("7. Show the less popular street in district");
            System.out.println("8. Exit");
            int userChose = scanner.nextInt();
            switch (userChose) {
                case 1 -> showDistrictList();
                case 2 -> showStreetInDistrict();
                case 3 -> showCarsInDistrict();
                case 4 -> showTheMostPopularDistrict();
                case 5 -> showTheLessPopularDistrict();
                case 6 -> showTheMostPopularStreetInDistrict();
                case 7 -> showTheLessPopularStreetInDistrict();
                case 8 -> shouldContinue = false;
                default -> System.out.println("Zły Znak");
            }
        }
    }

    private void showTheLessPopularStreetInDistrict() {
        System.out.println("Podaj numer dzielnicy");
        int districtId = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        String minStreet = "";
        for (District district : districts) {
            if (district.id == districtId) {
                for (Street street : district.streets) {
                    int counter = 0;
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.street.name.equals(street.name)) {
                            counter++;
                        }
                    }
                    if (counter < min) {
                        min = counter;
                        minStreet = street.name;
                    }
                }
            }
        }
        System.out.println("Najmniej popularna ulica to: " + minStreet);
    }

    private void showTheLessPopularDistrict() {
        int min = Integer.MAX_VALUE;
        int minId = 0;
        for (District district : districts) {
            int counter = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.district.id == district.id) {
                    counter++;
                }
            }
            if (counter < min) {
                min = counter;
                minId = district.id;
            }
        }
        System.out.println("Najmniej popularna dzielnica to: " + minId);
    }

    private void showTheMostPopularStreetInDistrict() {
        System.out.println("Podaj numer dzielnicy");
        int districtId = scanner.nextInt();
        int max = 0;
        String maxStreet = "";
        for (District district : districts) {
            if (district.id == districtId) {
                for (Street street : district.streets) {
                    int counter = 0;
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.street.name.equals(street.name)) {
                            counter++;
                        }
                    }
                    if (counter > max) {
                        max = counter;
                        maxStreet = street.name;
                    }
                }
            }
        }
        System.out.println("Najpopularniejsza ulica to: " + maxStreet);
    }

    private void showTheMostPopularDistrict() {
        int max = 0;
        int maxId = 0;
        String name = "";
        for (District district : districts) {
            int counter = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.district.id == district.id) {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
                maxId = district.id;
                name = district.name;
            }
        }
        System.out.println("Najpopularniejsza dzielnica to: " + maxId + " " + name);
    }

    private void showCarsInDistrict() {
        System.out.println("Podaj numer dzielnicy");
        int districtId = scanner.nextInt();
        for (District district : districts) {
            if (district.id == districtId) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.district.id == districtId) {
                        vehicle.vehicleInfo();
                    }
                }
            }
        }
    }

    private void showStreetInDistrict() {
        System.out.println("Podaj numer dzielnicy");
        int districtId = scanner.nextInt();
        for (District district : districts) {
            if (district.id == districtId) {
                for (Street street : district.streets) {
                    System.out.println(street.name);
                }
            }
        }
    }

    private void streetMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Street Menu:");
            System.out.println("1. Show all streets");
            System.out.println("2. Show street info by name");
            System.out.println("3. Show cars in street");
            System.out.println("4. Show the most popular street");
            System.out.println("5. Show the less popular street");
            System.out.println("6. Exit");
            int userChose = scanner.nextInt();
            switch (userChose) {
                case 1 -> showAllStreet();
                case 2 -> streetInfoByName();
                case 3 -> showCarsInStreet();
                case 4 -> showTheMostPopularStreet();
                case 5 -> showTheLessPopularStreet();
                case 6 -> shouldContinue = false;
                default -> System.out.println("Zły Znak");
            }
        }
    }

    private void showTheLessPopularStreet() {
        int min = Integer.MAX_VALUE;
        String streetName = "";
        for (Street street : streets) {
            if (street.vehicles.size() < min) {
                min = street.vehicles.size();
                streetName = street.name;
            }
        }
        System.out.println("Najmniej popularna ulica to " + streetName + " z " + min + " samochodami");
    }

    private void showTheMostPopularStreet() {
        int max = 0;
        String streetName = "";
        for (Street street : streets) {
            if (street.vehicles.size() > max) {
                max = street.vehicles.size();
                streetName = street.name;
            }
        }
        System.out.println("Najpopularniejsza ulica to " + streetName + " z " + max + " samochodami");
    }

    private void showCarsInStreet() {
        System.out.println("Podaj nazwę ulicy");
        String streetName = scanner.nextLine();
        int carCounter = 0;
        for (Street street : streets) {
            if (street.name.equals(streetName)) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.street.name.equals(streetName)) {
                        System.out.println(vehicle.name);
                        carCounter++;
                    }
                }
            }
            if (carCounter == 0)
                System.out.println("Brak samochodów w ulicy");
        }
    }

    private void showAllStreet() {
        for (Street street : streets) {
            System.out.println(street.name);
        }
    }

    private void streetInfoByName() {
        System.out.println("Podaj nazwę ulicy");
        String streetName = scanner.nextLine();
        for (Street street : streets) {
            if (street.name.equals(streetName)) {
                System.out.println(street.name);
            }
        }
    }


    private void carMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Car Menu:");
            System.out.println("1. Show all cars");
            System.out.println("2. Show car info by registration number");
            System.out.println("3. Exit");
            int userChose = scanner.nextInt();
            switch (userChose) {
                case 1 -> showAllCars();
                case 2 -> showCarInfoByRegistrationNumber();
                case 3 -> shouldContinue = false;
                default -> System.out.println("Zły Znak");
            }
        }
    }
}