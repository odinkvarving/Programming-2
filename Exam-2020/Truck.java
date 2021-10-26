/**
 * Truck is a subclass of Vehicle, where an exact value for passing during/outside rush hour is given
 */

public class Truck extends Vehicle{

    /**
     * The constructor for this class
     * @param licensePlateNumber the license plate number for this vehicle
     * @param totalWeight the total weight for this vehicle
     */
    public Truck(String licensePlateNumber, int totalWeight) {
        super(licensePlateNumber, totalWeight, 101.0, 86.0);
    }
}
