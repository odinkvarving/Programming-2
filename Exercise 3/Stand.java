import java.util.ArrayList;

public class Stand extends Tribune {
    private int noSoldTickets = 0;
    private ArrayList<Ticket> listStandTickets;

    public Stand(String tribuneName, int capacity, int price){
        super(tribuneName, capacity, price);
        this.listStandTickets = new ArrayList<>();

    }

    @Override
    public ArrayList<Ticket> buyTicket(int noOfTickets){

        if(findNumberOfSoldTickets() == getCapacity()){
            System.out.println("Ingen flere biletter tilgjengelig.");
            return null;
        }
        else {
            for (int i = 0; i <= noOfTickets; i++) {
                listStandTickets.add(new StandingTicket(getTribuneName(), getPrice()));
                noSoldTickets++;
            }
        }
        return listStandTickets;
    }

    public int findNumberOfSoldTickets(){
        return noSoldTickets;
    }

    public int findIncome(){
        return findNumberOfSoldTickets()*getPrice();
    }
}
