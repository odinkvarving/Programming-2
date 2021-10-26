package no.ntnu.idatx2001.oblig5.zoo;

import java.time.LocalDate;

class WildAnimalFactory {

    private static WildAnimalFactory single_instance = null;

    private WildAnimalFactory(){
    }

    public static WildAnimalFactory getInstance(){
        if(single_instance == null){
        single_instance = new WildAnimalFactory();
        }
        return single_instance;
    }

    public ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, LocalDate dateOfBirth, String name, String address){
        MaleIndividual maleBear = new MaleIndividual("Brunbjørn", "Ursus arctos", "Ursidae", arrivalDate, name, dateOfBirth, true, address);
        return maleBear;
    }

    public ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, LocalDate dateOfBirth, String name, String address, int noLitters){
        FemaleIndividual femaleWolf = new FemaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address, noLitters);
        return femaleWolf;
    }

    public ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, LocalDate dateOfBirth, String name, String address){
        MaleIndividual maleWolf = new MaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address);
        return maleWolf;
    }
}
