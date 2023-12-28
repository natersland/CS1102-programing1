package data;

/**
 * Interface for motorcycle-specific functionalities.
 */
public interface MotorVehicle {
    /**
     * Sets the number of wheels of the motorcycle.
     */
    public void settingNumberOfWheels();

    /**
     * Get the number of wheels of the motorcycle.
     */
    public int getNumberOfWheels();

    /**
     * Prints the type of the motorcycle.
     */
    public Motorcycle.TypeOfMotorCycle getTypeOfMotorCycle();
}
