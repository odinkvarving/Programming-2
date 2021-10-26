/**
 * Vehicle is an abstract class that contains the object variables and methods that are the same for every subclass of this class
 * Implements the Interface-class Payable with two methods - getLicensePlateNumber() and getCost()
 */

public abstract class Vehicle implements Payable{

    private String licensePlateNumber;
    private final int totalWeight;
    private final double inRushHour;
    private final double outsideRushHour;

    /**
     * The constructor for this class
     * @param licensePlateNumber
     * @param totalWeight
     * @param inRushHour
     * @param outsideRushHour
     */

    public Vehicle(String licensePlateNumber, int totalWeight, double inRushHour, double outsideRushHour){
        this.licensePlateNumber = licensePlateNumber;
        this.totalWeight = totalWeight;
        this.inRushHour = inRushHour;
        this.outsideRushHour = outsideRushHour;
    }

    /**
     * Method for obtaining the license number
     * @return the license number
     */
    public String getLicensePlateNumber(){
        return licensePlateNumber;
    }

    /**
     * Method for obtaining the total weight
     * @return the total weight
     */
    public int getTotalWeight(){
        return totalWeight;
    }

    /**
     * Method for obtaining cost of passing a toll ring during rush hour
     * @return the cost of passing a toll ring during rush hour as a double
     */
    public double getInRushHour(){
        return inRushHour;
    }

    /**
     * Method for obtaining cost of passing a toll ring outside of rush hour
     * @return the cost of passing a toll ring outside of rush hour as a double
     */
    public double getOutsideRushHour(){
        return outsideRushHour;
    }

    /**
     * Method for setting a new license number
     * @param newLicensePlateNumber the new license number
     */
    public void setLicensePlateNumber(String newLicensePlateNumber){
        this.licensePlateNumber = newLicensePlateNumber;
    }

    /**
     * Method for obtaining the cost of passing a toll ring, based on if the vehicle passes during rush hour or not
     * @param withinRushHour boolean stating if the time is rush hour or not
     * @return the cost of passing a toll ring during this time
     */
    public double getCost(boolean withinRushHour){
        if(withinRushHour) {
            return getInRushHour();
        }
        return getOutsideRushHour();
    }
}
