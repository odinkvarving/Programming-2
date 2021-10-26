abstract class Ticket {
    private final String tribuneName;
    private final int price;

    public Ticket(String tribuneName, int price){
        if(tribuneName == null || tribuneName.trim().equals("")){
            throw new IllegalArgumentException(" Tribunenavn må oppgis.");
        }
        this.tribuneName = tribuneName;
        this.price = price;
    }

    public String toString(){
        return "\nTribune: " + tribuneName + " Pris: " + price;
    }
}
