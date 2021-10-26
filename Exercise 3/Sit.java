import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sit extends Tribune {
    protected int[] noBusy;
    private int rowCapacity;

    public Sit(String tribuneName, int capacity, int price, int row) {
        super(tribuneName, capacity, price);
        this.noBusy = new int[row];
        this.rowCapacity = getCapacity()/row;
    }

    public int getAvailableRow(int noOfTickets){
        for(int i = 0; i < noBusy.length; i++){
            int availableSeats = rowCapacity - noBusy[i];
            if(noOfTickets <= availableSeats){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Ticket> buyTicket(int noOfTickets) {

            int row = getAvailableRow(noOfTickets);
            if(row < 0)
                return null;
            ArrayList<Ticket> tickets = new ArrayList<>();
            for(int i = 0; i < noOfTickets; i++){
                SittingTicket ticket = new SittingTicket(getTribuneName(), getPrice(), row + 1, noBusy[row] + 1);
                tickets.add(ticket);
                noBusy[row]++;
            }
        return tickets;
    }

    public int findNumberOfSoldTickets() {
        int sum = 0;

            for(int i = 0; i < noBusy.length; i++){
            sum += noBusy[i];
        }
            return sum;
    }

    public int findIncome() {
        int sum = 0;
        int sitIncome = 0;

        for(int i = 0; i < noBusy.length; i++){
            sum += noBusy[i];
            sitIncome = sum * getPrice();
        }
        return sitIncome;
    }
}
