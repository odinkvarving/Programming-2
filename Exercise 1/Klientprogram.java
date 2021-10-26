import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Klientprogram {

    public static void main(String[] args){

        ArrayList<Card> kortstokk = new ArrayList<Card>();
        Deck deck = new Deck(kortstokk);
        deck.fillDeck(kortstokk);
        int amount = 5;
        ArrayList<Card> random = deck.assign(amount);

        random.stream().filter(p -> p.getSuit() == 'S').forEach(s -> System.out.println(s + " - Spades "));

        // Bruker den random-genererte kortstokken til å løse de oppgavene hvor det virker fornuftig
        System.out.println(kortstokk.stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toList()));


        List<Character> fargeListe = kortstokk.stream().map(Card::getSuit).collect(Collectors.toList());
        System.out.println(fargeListe);

        int sumVerdi = 0;
        sumVerdi = random.stream().map(Card::getFace).reduce((a,b) -> a+b).get();
        System.out.println(sumVerdi);

        System.out.println(random.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 12));

        ArrayList<Card> pokerflush = deck.assign(22);

        if(pokerflush.stream().filter(p -> p.getSuit() == 'H' || p.getSuit() == 'D').collect(Collectors.toList()).size() == 5) {

            System.out.println(pokerflush + "\n Flush!");
        }
        else if(pokerflush.stream().filter(p -> p.getSuit() == 'S' || p.getSuit() == 'C').collect(Collectors.toList()).size() == 5){
            System.out.println(pokerflush + "\n Flush!");
        }
        else{
            System.out.println(pokerflush + " Ikke flush!");
        }
        Map<Character, Long> chars = kortstokk.stream().map(c -> c.getSuit()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //Hvordan fungerer dette?
    }
}
