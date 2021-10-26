import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TollPassage is a class used for representing a passage of a toll ring, with identifiers of the car passing
 */
public class TollPassage {
    private int id;
    private String licensePlateNumber;
    private double costOfPassage;
    private LocalTime timeOfPassage;
    private LocalDate dateOfPassage;

    /**
     * The constructor for this class
     * @param id id for the passage
     * @param licensePlateNumber the license number of the vehicle passing
     * @param timeOfPassage the time of passage
     * @param dateOfPassage the date of passage
     */
    public TollPassage(int id, String licensePlateNumber, LocalTime timeOfPassage, LocalDate dateOfPassage) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.timeOfPassage = timeOfPassage;
        this.dateOfPassage = dateOfPassage;
        if (timeOfPassage.isAfter(LocalTime.of(6, 30)) && timeOfPassage.isBefore(LocalTime.of(8, 59))) {
            this.costOfPassage = VehicleRegister.getInstance().searchByLicensePlateNumber(licensePlateNumber).getCost(true);
        } else if (timeOfPassage.isAfter(LocalTime.of(14, 30)) && timeOfPassage.isBefore(LocalTime.of(16, 29))) {
            this.costOfPassage = VehicleRegister.getInstance().searchByLicensePlateNumber(licensePlateNumber).getCost(true);
        } else {
            this.costOfPassage = VehicleRegister.getInstance().searchByLicensePlateNumber(licensePlateNumber).getCost(false);
        }
    }

    /**
     * Method for obtaining id of vehicle
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Method for obtaining license number of vehicle
     * @return the license number
     */
    public String getLicensePlateNumber(){
        return licensePlateNumber;
    }

    /**
     * Method for getting the cost of passage
     * @return the cost of passage
     */
    public double getCostOfPassage(){
        return costOfPassage;
    }

    /**
     * Method for getting the time of passage in time of day
     * @return the time of day the vehicle passed
     */
    public LocalTime getTimeOfPassage(){
        return timeOfPassage;
    }

    /**
     * Method for getting the date of passage
     * @return the date the vehicle passed
     */
    public LocalDate getDateOfPassage(){
        return dateOfPassage;
    }
}
