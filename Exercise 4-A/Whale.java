public class Whale extends Mammal implements IJumpable, ISwimmable{

    public Whale(String name, int animalID) {
        super(name, animalID);
    }

    @Override
    public boolean jump() {
        return true;
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnimal: Whale";
    }
}
