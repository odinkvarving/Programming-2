public class Pelican extends Oviparous implements IWalkable, IFlyable{

    public Pelican(String name, int animalID) {
        super(name, animalID);
    }

    @Override
    public boolean fly() {
        return true;
    }

    @Override
    public boolean walk() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnimal: Pelican";
    }
}
