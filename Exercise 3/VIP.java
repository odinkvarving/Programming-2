import java.util.ArrayList;
import java.util.Arrays;

public class VIP extends Sit {
    private String[][] spectator;

    public VIP(String tribuneName, int capacity, int price, int row) {
        super(tribuneName, capacity, price, row);
        this.spectator = new String[row][getCapacity()/row];
    }

    public ArrayList<Ticket> buyTicket(String[] spectator) {
        int row = getAvailableRow(spectator.length);
        if(row < 0)
            return null;
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < spectator.length; i++){
            SittingTicket VIPticket = new SittingTicket(getTribuneName(), getPrice(), row + 1, noBusy[row] + 1);
            tickets.add(VIPticket);
            this.spectator[row][noBusy[row]] = spectator[i];
            noBusy[row]++;
        }
        return tickets;
    }

    public int findNumberOfSoldTickets() {
        int sum = 0;

        for (int i = 0; i < noBusy.length; i++) {
            sum += noBusy[i];
        }
        return sum;
    }

    public int findIncome(){
        return findNumberOfSoldTickets()*getPrice();
    }

    public String toString(){
        return Arrays.deepToString(spectator);
    }
}