/**
 * PetrolCar is a subclass of Vehicle, where an exact value for passing during/outside rush hour is given
 */

public class PetrolCar extends Vehicle{

    /**
     * The constructor of this class
     * @param licensePlateNumber the license number for this vehicle
     * @param totalWeight the total weight for this vehicle
     */
    public PetrolCar(String licensePlateNumber, int totalWeight) {
        super(licensePlateNumber, totalWeight, 21.0, 17.0);
    }
}
