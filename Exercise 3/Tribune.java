import java.util.ArrayList;

public abstract class Tribune {
    private final String tribuneName;
    private final int capacity;
    private final int price;

    public Tribune(String tribuneName, int capacity, int price){
        this.tribuneName = tribuneName;
        this.capacity = capacity;
        this.price = price;
    }

    public String getTribuneName(){
        return tribuneName;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getPrice(){
        return price;
    }

    public int findNumberOfSoldTickets(){
        return 0;
    }

    public int findIncome(){
        return 0;
    }

    public ArrayList<Ticket> buyTicket(int noOfTickets){
        return null;
    }

    public ArrayList<Ticket> buyTicket(ArrayList<String> nameListOfBuyers){
        return buyTicket(nameListOfBuyers.size());
    }

    public String toString(){
        String res = " ";
        res += "Total income: ";
        return "Tribune: " + getTribuneName() + " Antall solgte billetter: " + findNumberOfSoldTickets() + " Kapasitet: " + getCapacity() + res + findIncome();
    }
}
