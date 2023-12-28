package data;

import java.util.Scanner;

/**
 * Represents a motorcycle with various properties.
 */
public class Motorcycle implements Vehicle, MotorVehicle {
    private String model;
    private int year;
    private String manufacturer;
    private int numberOfWheels;
    private TypeOfMotorCycle typeOfMotorCycle;


    /**
     * Enum representing different types of motorcycles.
     */
    public enum TypeOfMotorCycle {
        SPORT, CRUISER, OFF_ROAD
    }

    /**
     * Constructs a new Motorcycle instance.
     *
     * @param model            the model of the motorcycle
     * @param year             the year of manufacture
     * @param manufacturer     the manufacturer of the motorcycle
     * @param typeOfMotorCycle the type of motorcycle
     */
    public Motorcycle(String model, int year, String manufacturer, TypeOfMotorCycle typeOfMotorCycle) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.numberOfWheels = 0;
        this.typeOfMotorCycle = typeOfMotorCycle;
    }

    public String toString() {
        return "🏍️Model: " + this.model + "\nYear: " + this.year + "\nManufacturer: " + this.manufacturer + "\nNumber of wheels: " + this.numberOfWheels + "\nType of motorcycle: " + this.typeOfMotorCycle;
    }

    // Implementation of Vehicle and MotorVehicle interface methods with appropriate documentation

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
    public void settingNumberOfWheels() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the number of wheels of the motorcycle: ");
            if(scanner.hasNextInt()) {
                this.numberOfWheels = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please try again.");
                settingNumberOfWheels();
            }
            if(this.numberOfWheels < 0) {
                System.out.println("Invalid input. Please try again.");
                settingNumberOfWheels();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            settingNumberOfWheels();
        }
    }

    @Override
    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    @Override
    public TypeOfMotorCycle getTypeOfMotorCycle() {
        return this.typeOfMotorCycle;
    }
}
