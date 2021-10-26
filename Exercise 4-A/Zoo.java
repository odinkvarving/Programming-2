import java.util.ArrayList;
import java.util.Collection;

public class Zoo {
    private final String name;
    private final ArrayList<Animal> animalList = new ArrayList<>();

    public Zoo(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Collection<Animal> getAnimals(){
        return animalList;
    }

    public void setAnimals(Collection<Animal> animals){
        this.animalList.addAll(animals);
    }
}
