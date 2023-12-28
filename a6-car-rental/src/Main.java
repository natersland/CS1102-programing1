import data.Car;
import data.Motorcycle;
import data.Truck;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Ford", 2023, "FantasyCar", Car.FuelType.ELECTRIC);
        car.settingNumberOfDoors();
        System.out.println(car);

        Motorcycle motorcycle = new Motorcycle("Harley", 2021, "HarleyDavidson", Motorcycle.TypeOfMotorCycle.CRUISER);
        motorcycle.settingNumberOfWheels();
        System.out.println(motorcycle);

        Truck truck = new Truck("Volvo", 2021, "Volvo", Truck.TransmissionType.AUTOMATIC);
        truck.settingCargoCapacity();
        System.out.println(truck);

    }
}