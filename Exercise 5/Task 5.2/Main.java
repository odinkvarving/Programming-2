package no.ntnu.idatx2001.oblig5.zoo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.*;

public class Main {

    private static final Logger log = Logger.getLogger("ZooLogger");

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException{
        WildAnimalFactory wildAnimalFactory = WildAnimalFactory.getInstance();

        Handler consoleHandler = null;
        Handler fileHandler = null;


        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./text.log");

            log.addHandler(consoleHandler);
            log.addHandler(fileHandler);

            consoleHandler.setLevel(Level.FINE);
            fileHandler.setLevel(Level.FINE);
            log.setLevel(Level.FINE);
            log.config("Configuration done");
        }catch (IOException e){
            log.log(Level.SEVERE, "Error occurred in FileHandler.", e);
        }


            ScandinavianWildAnimal ulla = wildAnimalFactory.newFemaleWolf(LocalDate.of(2015,2,26),
                    LocalDate.of(2015,4,29), "", "Innhegning 2, Skandinaviske rovdyr", 2);
            log.info(ulla.toString());


            ScandinavianWildAnimal jens = wildAnimalFactory.newMaleWolf(LocalDate.of(2012, 6, 29),
                    LocalDate.of(2014, 2, 10), "Jens", "Innhegning 2, Skandinaviske rovdyr");
            log.info(jens.toString());


            ScandinavianWildAnimal konrad = wildAnimalFactory.newMaleBear(LocalDate.of(2008, 10, 15),
                    LocalDate.of(2009, 5, 4), "Konrad", "Innhegning 1, Skandinaviske rovdyr");
            log.info(konrad.toString());
    }
}
