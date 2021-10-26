
public class Card {

    private final char suit;
    private final int face;

    public Card(char suit, int face){
        this.suit = suit;
        this.face = face;
    }

    public String toString(){
        return String.format("%s%s", suit, face);
    }

    public char getSuit(){
        return suit;
    }

    public String suitType(){
        if(this.getSuit() == 'S'){
            return "Spade";
        }
        else if(this.getSuit() == 'H'){
            return "Hearts";
        }
        else if(this.getSuit() == 'D'){
            return "Diamonds";
        }
        else{
            return "Clubs";
        }
    }

    public int getFace() {
        return face;
    }
}
