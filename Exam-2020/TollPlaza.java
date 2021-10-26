import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TollPlaza is a class that is used for registering toll passages
 */
public class TollPlaza {
    TollPassageRegister tollPassageRegister = new TollPassageRegister();
    VehicleRegister vehicleRegister = new VehicleRegister();

    private final String name;
    private final int ID;

    /**
     * Constructor of the class
     * @param name the name of the toll plaza
     * @param id the id of the toll plaza
     */
    public TollPlaza(String name, int id){
        this.name = name;
        this.ID = id;

    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    /**
     * Method for registering new toll passage
     * @param licensePlateNumber license number of vehicle passing
     * @param date date of passage
     * @param time time of passage
     * @return true or false
     */
    public boolean registerTollPassage(String licensePlateNumber, LocalDate date, LocalTime time){
        for (Vehicle v : vehicleRegister.getAllVehicles()) {
            if(v.getLicensePlateNumber().equals(licensePlateNumber)) {
                tollPassageRegister.registerNewPassage(new TollPassage(this.ID, licensePlateNumber, time, date));
                return true;
            }
        }
        return false;
    }

}
