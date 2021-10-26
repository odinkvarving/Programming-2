public class Crocodile extends Oviparous implements ISwimmable, IWalkable{

    public Crocodile(String name, int animalID) {
        super(name, animalID);
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public boolean walk() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnimal: Crocodile";
    }
}
