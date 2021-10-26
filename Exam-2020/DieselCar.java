/**
 * DieselCar is a subclass of Vehicle, where an exact value for passing during/outside rush hour is given
 */

public class DieselCar extends Vehicle {

    /**
     * The constructor for this class
     * @param licensePlateNumber the license number for this vehicle
     * @param totalWeight the total weight for this vehicle
     */
    public DieselCar(String licensePlateNumber, int totalWeight) {
        super(licensePlateNumber, totalWeight, 23.0, 19.0);

    }
}
