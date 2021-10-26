import java.util.*;

public class Klient {

    public static void main(String[] args) {
        ArrayList<Tribune> TribuneList = new ArrayList<>();
        Tribune sitTribune = new Sit(" Sit-Tribune", 50, 150, 5);
        Tribune standTribune = new Stand("Stand-Tribune", 50, 100);
        Tribune standTribune2 = new Stand("Stand-Tribune 2", 50, 100);
        Tribune VIPTribune = new VIP("VIP-Tribune", 15, 500, 3);

        TribuneList.add(sitTribune);
        TribuneList.add(standTribune);
        TribuneList.add(standTribune2);
        TribuneList.add(VIPTribune);

        ArrayList<String> sitList = new ArrayList<>();
        ArrayList<String> VIPList = new ArrayList<>();
        String navn1 = "Petter";
        String navn2 = "Kåre";
        String navn3 = "Ole";
        sitList.add(navn1);
        sitList.add(navn2);
        sitList.add(navn3);
        VIPList.add(navn1);
        VIPList.add(navn2);
        VIPList.add(navn3);

        System.out.println(sitTribune.buyTicket(sitList));
        System.out.println(standTribune.buyTicket(7));
        System.out.println(standTribune2.buyTicket(5));
        System.out.println(VIPTribune.buyTicket(5));
        
        //Arrays.sort(TribuneList);

        Collections.sort(TribuneList, (a,b) -> a.findIncome() - b.findIncome());
        TribuneList.forEach(a -> System.out.println(a));
    }
}
