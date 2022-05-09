package design_patterns;

abstract class Vehicle {
    int wheels;

    abstract int getWheels();
}


class Car extends Vehicle {
    Car(int wheels) {
        this.wheels = wheels;
    }

    @Override
    int getWheels() {
        return wheels;
    }
}

class Bike extends Vehicle {
    Bike(int wheels) {
        this.wheels = wheels;
    }

    @Override
    int getWheels() {
        return wheels;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car(4);
        } else {
            return new Bike(2);
        }
    }

}

public class FactoryExample {
    public static void main(String[] args) {
        Vehicle carVehicle = VehicleFactory.getInstance("Car");
        System.out.println("Car Wheels " + carVehicle.getWheels());
        Vehicle bikeVehicle = VehicleFactory.getInstance("Bike");
        System.out.println("Bike Wheels " + bikeVehicle.getWheels());
    }
}
