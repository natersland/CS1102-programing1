package data;

/**
 * Interface for truck-specific functionalities.
 */
public interface TruckVehicle {
    /**
     * Sets the cargo capacity of the truck.
     */
    public void settingCargoCapacity();

    /**
     * Get the cargo capacity of the truck.
     */
    public int getCargoCapacity();

    /**
     * Get the transmission type of the truck.
     */
    public Truck.TransmissionType getTransmissionType();

    // Inherited methods from Vehicle interface
}
