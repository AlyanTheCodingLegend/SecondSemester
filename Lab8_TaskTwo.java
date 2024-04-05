import java.util.ArrayList;

// Interface for CarbonFootprint
interface CarbonFootprint {
    double getCarbonFootprint();
}

// Building class
class Building implements CarbonFootprint {
    private String buildingName;
    private double naturalGasConsumption; // in therms

    public Building(String buildingName, double naturalGasConsumption) {
        this.buildingName = buildingName;
        this.naturalGasConsumption = naturalGasConsumption;
    }

    @Override
    public double getCarbonFootprint() {
        // Multiply therms of natural gas by a factor of 11.7 to get the pounds of carbon dioxide emissions
        return naturalGasConsumption * 11.7;
    }

    public String getBuildingName() {
        return buildingName;
    }
}

// Car class
class Car implements CarbonFootprint {
    private String carModel;
    private double petrolConsumption; // in liters

    public Car(String carModel, double petrolConsumption) {
        this.carModel = carModel;
        this.petrolConsumption = petrolConsumption;
    }

    @Override
    public double getCarbonFootprint() {
        // Burning one liter of petrol creates 2.31kg of CO2
        return petrolConsumption * 2.31;
    }

    public String getCarModel() {
        return carModel;
    }
}

// Bicycle class
class Bicycle implements CarbonFootprint {
    private double distanceTraveled; // in kilometers

    public Bicycle(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public double getCarbonFootprint() {
        // Carbon footprint of a bicycle is approximately 21 grams of CO2 per kilometer traveled
        return distanceTraveled * 21 / 1000; // convert grams to kilograms
    }
}

public class Lab8_TaskTwo {
    public static void main(String args[]) {
        ArrayList<CarbonFootprint> carbonFootprints = new ArrayList<>();

        // Create objects of each class
        Building building = new Building("Office Building", 100); // Assume 100 therms of natural gas consumption
        Car car = new Car("Toyota Camry", 10); // Assume 10 liters of petrol consumption
        Bicycle bicycle = new Bicycle(50); // Assume traveled 50 kilometers

        // Add objects to ArrayList
        carbonFootprints.add(building);
        carbonFootprints.add(car);
        carbonFootprints.add(bicycle);

        // Iterate through ArrayList and print carbon footprints
        for (CarbonFootprint footprint : carbonFootprints) {
            if (footprint instanceof Building) {
                Building b = (Building) footprint;
                System.out.println("Building: " + b.getBuildingName() + ", Carbon Footprint: " + b.getCarbonFootprint() + " pounds of CO2");
            } else if (footprint instanceof Car) {
                Car c = (Car) footprint;
                System.out.println("Car: " + c.getCarModel() + ", Carbon Footprint: " + c.getCarbonFootprint() + " kg of CO2");
            } else if (footprint instanceof Bicycle) {
                Bicycle b = (Bicycle) footprint;
                System.out.println("Bicycle, Carbon Footprint: " + b.getCarbonFootprint() + " kg of CO2");
            }
        }
    }
}
