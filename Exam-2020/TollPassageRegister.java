import java.util.ArrayList;

/**
 * TollPassageRegister is a class used for registering new passages for tolls
 */
public class TollPassageRegister {
    private ArrayList<TollPassage> tollPassageList = new ArrayList<>();

    /**
     * Method for registering a new passage
     * @param tollPassage The TollPassage to be registered
     */
    public void registerNewPassage(TollPassage tollPassage){
        if(tollPassageList.contains(tollPassage)) {
            throw new IllegalArgumentException("This passage has already been registered!");
        }
        tollPassageList.add(tollPassage);
    }

    /**
     * Method for obtaining a list of all passages
     * @return a list of all passages
     */
    public ArrayList<TollPassage> getAllPassages(){
        return tollPassageList;
    }
}
