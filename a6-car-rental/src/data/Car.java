package data;

import java.util.Scanner;

/**
 * Represents a car with various properties.
 */

public class Car implements Vehicle, CarVehicle {
    private String model;
    private int year;
    private String manufacturer;
    private int numberOfDoors;
    private FuelType fuelType;


    /**
     * Fuel types that a car can use.
     */

    public enum FuelType {
        PETROL, DIESEL, ELECTRIC
    }

    /**
     * Constructs a new Car instance.
     *
     * @param model         the model of the car
     * @param year          the year of manufacture
     * @param manufacturer  the manufacturer of the car
     * @param fuelType      the type of fuel the car uses
     */

    public Car(String model, int year, String manufacturer, FuelType fuelType) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.numberOfDoors = 0;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "🚗Model: " + this.model + "\nYear: " + this.year + "\nManufacturer: " + this.manufacturer +
                "\nNumber of doors: " + this.numberOfDoors + "\nFuel type: " + this.fuelType;
    }

    // Implementation of Vehicle and CarVehicle interface methods with appropriate documentation

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }


    @Override
    public void settingNumberOfDoors() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the number of doors of the car: ");
            if (scanner.hasNextInt()) {
                this.numberOfDoors = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please try again.");
                settingNumberOfDoors();
            }
            if (this.numberOfDoors < 0) {
                System.out.println("Invalid input. Please try again.");
                settingNumberOfDoors();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            settingNumberOfDoors();
        }
    }

    @Override
    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    @Override
    public FuelType getFuelType() {
        return this.fuelType;
    }

}


