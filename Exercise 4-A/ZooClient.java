import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ZooClient {
    public static void main(String[] args) throws ZooException{
        Zoo zoo = new Zoo("Kristiansand dyrepark");

        Collection<Animal> animals = new ArrayList<Animal>();

        animals.add(new Crocodile("Crocodylus niloticus", 1001));
        animals.add(new Crocodile("Crocodylus niloticus", 1002));
        animals.add(new Crocodile("Crocodylus porosus", 1101));
        animals.add(new Crocodile("Crocodylus porosus", 1102));

        animals.add(new Pelican("Brown Pelican", 4001));
        animals.add(new Pelican("Dalmatian Pelican", 4101));

        animals.add(new Whale("Blue whale", 2001));
        animals.add(new Whale("Blue whale", 2002));
        animals.add(new Whale("Minke whale", 2101));
        animals.add(new Whale("Minke whale", 2102));

        animals.add(new Bat("Acerodon", 3001));
        animals.add(new Bat("Cistugo", 3002));

        zoo.setAnimals(animals);

        //Lambda uttrykk som finner alle dyr som kan fly og kaller .fly() metoden på hver av dem
        zoo.getAnimals().forEach(p -> {
            if (p instanceof IFlyable){
                System.out.println("\n" + ((IFlyable) p).fly() + p.toString());
            }
        });

        //Lambda uttrykk som finner alle pattedyr som kan hoppe og kaller .jump() metoden på hver av dem
        zoo.getAnimals().forEach(p -> {
            if (p instanceof Mammal && p instanceof IJumpable) {
                System.out.println("\n" + ((IJumpable)p).jump() + p.toString());
            }
        });


        System.out.println("\nFetching animals with 'walking' trait... ");
        List<Object> walker = zoo.getAnimals().stream().filter(p -> p instanceof IWalkable).collect(Collectors.toList());
        try {
                walker.stream().forEach(p -> {
                    if(p instanceof IFlyable) {
                        ((IFlyable) p).fly();
                    }
                    else throw new ZooException();
                });
        }
        catch (ZooException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
