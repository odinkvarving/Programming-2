/**
 * ElectricalCar is a subclass of Vehicle, where an exact value for passing during/outside rush hour is given
 */

public class ElectricalCar extends Vehicle{

    /**
     * The constructor for this class
     * @param licensePlateNumber the license number of this vehicle
     * @param totalWeight the total weight for this vehicle
     */
    public ElectricalCar(String licensePlateNumber, int totalWeight) {
        super(licensePlateNumber, totalWeight, 8.0, 4.0);


    }
}
