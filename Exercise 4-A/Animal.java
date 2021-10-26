public class Animal {

    private final String name;
    private final int animalID;

    public Animal(String name, int animalID){
        if(name == null) throw new IllegalArgumentException("Name is empty. ");
        if(animalID == 0) throw new IllegalArgumentException("AnimalID is empty. ");
        this.name = name;
        this.animalID = animalID;
    }

    public String toString(){
        return "\nName: " + name + "\nAnimal ID: " + animalID;
    }
}
