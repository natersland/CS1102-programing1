package data;

/**
 * Interface for car-specific functionalities.
 */
public interface CarVehicle {
    /**
     * Sets the number of doors of the car.
     */
    public void settingNumberOfDoors();

    /**
     * Get the number of doors of the car.
     */
    public int getNumberOfDoors();

    /**
     * Get the fuel type of the car.
     */
    public Car.FuelType getFuelType();
}
