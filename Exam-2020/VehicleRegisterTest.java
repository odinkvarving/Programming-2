import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Junit-test class for testing the VehicleRegister class and all of its methods
 */
public class VehicleRegisterTest {


    /**
     * Test for checking if we are able to register a new vehicle
     * Uses @assertTrue to test if the vehicleRegister contains the newly registered vehicle1
     * Uses @assertFalse to test if the vehicleRegister contains the newly registered vehicle2, which has the same license number as vehicle1
     */
    @Test
    public void registerNewVehicle(){
        VehicleRegister vehicleRegister = new VehicleRegister();
        Vehicle vehicle1 = new DieselCar("BR4100", 2100);
        Vehicle vehicle2 = new ElectricalCar("BR4100", 1200);
        vehicleRegister.registerNewVehicle(vehicle1);
        vehicleRegister.registerNewVehicle(vehicle2);
        assertTrue(vehicleRegister.getAllVehicles().contains(vehicle1));
        assertFalse(vehicleRegister.getAllVehicles().contains(vehicle2));
    }

    /**
     * Test for checking if we are able to find a vehicle based on a given license number
     * Uses @assertSame to check if the registered vehicle has the same license number as what is given in the searchByLicensePlateNumber()-method
     * Uses @assertNull to check if we are able to find a vehicle with an unregistered license number
     */
    @Test
    public void searchByLicensePlateNumber(){
        VehicleRegister vehicleRegister = new VehicleRegister();
        Vehicle vehicle1 = new DieselCar("BR4100", 2100);
        vehicleRegister.registerNewVehicle(vehicle1);
        assertSame(vehicle1, vehicleRegister.searchByLicensePlateNumber("BR4100"));
        assertNull(vehicleRegister.searchByLicensePlateNumber("XL3212"));
    }

    /**
     * Test for finding vehicles above a given weight
     * Uses @assertEquals to check if the list created by the searchByTotalWeight is actually 1 when there is only 1 car that has a total weight above the limit
     * Uses @assertEquals to check that no vehicles are found if the weight-limit is above the total weight of both the vehicles
     */
    @Test
    public void searchByTotalWeight(){
        int totalWeight = 1500;
        VehicleRegister vehicleRegister = new VehicleRegister();
        Vehicle vehicle1 = new DieselCar("BR4100", 2100);
        Vehicle vehicle2 = new DieselCar("XL3214", 1450);
        vehicleRegister.registerNewVehicle(vehicle1);
        vehicleRegister.registerNewVehicle(vehicle2);
        assertEquals(vehicleRegister.searchByTotalWeight(totalWeight).size(), 1);
        int falseTotalWeight = 2200;
        assertEquals(vehicleRegister.searchByTotalWeight(falseTotalWeight).size(), 0);

    }
}
