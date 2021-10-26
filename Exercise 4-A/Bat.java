public class Bat extends Mammal implements IFlyable{

    public Bat(String name, int animalID) {
        super(name, animalID);
    }

    @Override
    public boolean fly() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnimal: Bat";
    }
}
