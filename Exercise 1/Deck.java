import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private  ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> fillDeck(ArrayList<Card> arrayList){
        char[] suit = "SHDC".toCharArray();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 12; j++) {
                deck.add(new Card(suit[i], j+2));
            }
        }
        return deck;
    }

    public ArrayList<Card> assign(int n) {
        ArrayList<Card> copy = new ArrayList<>(deck);
        ArrayList<Card> randomCards = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(copy.size());
            randomCards.add(copy.get(index));
            copy.remove(index);
        }
        return randomCards;
    }
}
