import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * VehicleRegister is a class for registering new Vehicles
 * This class is a singleton-class because it has a static object variable - so that it only gets value once
 * And a static method so that it can be called without creating a object of VehicleRegister
 */
public class VehicleRegister {
    private static VehicleRegister instance;
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Empty constructor (vehicleList already initialized)
     */
    public VehicleRegister(){

    }
    /**
     * Method for finding all registered vehicles
     * @return an ArrayList of type Vehicles containing all registered vehicles
     */
    public ArrayList<Vehicle> getAllVehicles(){
        return vehicleList;
    }

    /**
     * Method for registering a new Vehicle, that checks if the Vehicle is already registered using the alreadyExists()-method
     * @param vehicle the vehicle to be registered
     */
    public void registerNewVehicle(Vehicle vehicle){
        if(alreadyRegistered(vehicle.getLicensePlateNumber())) {
            vehicleList.add(vehicle);
        }
    }

    /**
     * Method for checking if a vehicle is already registered, using a lambda expression that finds any vehicle with matching license number as the one in the parameter
     * @param licensePlateNumber the license number that is checked for match is vehicleList
     * @return true if no vehicle with this license number is already registered, false if a vehicle with this license number is already registered
     */
    public boolean alreadyRegistered(String licensePlateNumber){
        if(vehicleList.stream().anyMatch(v -> v.getLicensePlateNumber().equals(licensePlateNumber))) {
            throw new IllegalArgumentException("Vehicle with this license number already registered!");
        }
        return true;
    }


    /**
     * Method for finding a vehicle with a specific license number
     * @param licensePlateNumber the license number for which to find a matching vehicle
     * @return the vehicle found, returns null if no vehicle was found
     */
    public Vehicle searchByLicensePlateNumber(String licensePlateNumber){
        for (Vehicle v: vehicleList) {
            if(v.getLicensePlateNumber().equals(licensePlateNumber)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Method for finding all vehicles with a total weight above a given weight
     * @param totalWeight the weight that the vehicle has to be above
     * @return a collection of vehicles that has a total weight above the given weight
     */
    public Collection<Vehicle> searchByTotalWeight(int totalWeight) {
        return vehicleList.stream().filter(v -> v.getTotalWeight() > totalWeight).collect(Collectors.toList());
    }

    public static VehicleRegister getInstance(){
        if(instance == null) {
            instance = new VehicleRegister();
        }
        return instance;
    }
}
