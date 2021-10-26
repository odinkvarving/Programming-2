/**
 * Motorcycle is a subclass of Vehicle, where an exact value for passing during/outside rush hour is given (this is zero for motorcycles)
 */

public class Motorcycle extends Vehicle{

    /**
     * The constructor for this class
     * @param licensePlateNumber the license number for this vehicle
     * @param totalWeight the total weight for this vehicle
     */
    public Motorcycle(String licensePlateNumber, int totalWeight) {
        super(licensePlateNumber, totalWeight, 0, 0);
    }
}
