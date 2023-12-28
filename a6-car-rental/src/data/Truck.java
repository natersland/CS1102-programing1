package data;

import java.util.Scanner;

/**
 * Represents a truck with specific attributes such as model, year, manufacturer, cargo capacity, and transmission type.
 */
public class Truck implements Vehicle, TruckVehicle {
    private String model;
    private int year;
    private String manufacturer;
    private int cargoCapacity;
    private TransmissionType transmissionType;

    /**
     * Enum for the types of transmission a truck can have.
     */
    public enum TransmissionType {
        MANUAL, AUTOMATIC
    }

    /**
     * Constructs a new Truck instance.
     *
     * @param model             the model of the truck
     * @param year              the year the truck was manufactured
     * @param manufacturer      the manufacturer of the truck
     * @param transmissionType  the type of transmission the truck uses
     */
    public Truck(String model, int year, String manufacturer, TransmissionType transmissionType) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.cargoCapacity = 0;
        this.transmissionType = transmissionType;
    }

    public String toString() {
        return "\uD83D\uDE9AModel: " + this.model + "\nYear: " + this.year + "\nManufacturer: " + this.manufacturer + "\nCargo capacity: " + this.cargoCapacity + "\nTransmission type: " + this.transmissionType;
    }

    // Implementation of Vehicle and TruckVehicle interface methods with appropriate documentation

    @Override
    public void settingCargoCapacity() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the cargo capacity of the truck: ");
            if(scanner.hasNextInt()) {
                this.cargoCapacity = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please try again.");
                settingCargoCapacity();
            }
            if(this.cargoCapacity < 0) {
                System.out.println("Invalid input. Please try again.");
                settingCargoCapacity();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            settingCargoCapacity();
        }
    }

    @Override
    public int getCargoCapacity() {
        return this.cargoCapacity;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return this.transmissionType;
    }

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
}
