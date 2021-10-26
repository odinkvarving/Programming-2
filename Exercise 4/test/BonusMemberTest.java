package no.ntnu.idata1001.oblig4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.logging.Level;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import no.ntnu.idata1001.oblig4.MyLogger;

public class BonusMemberTest {

    private Personals personals;
    private BonusMember bonusMember;
    private MyLogger myLogger;

    @BeforeEach
    public void beforeEach() throws IOException {
        this.personals = new Personals("Odin", "Kvarving", "Odinkvarving@hotmail.com", "banan");

        // Now, since BonusMember is an abstract class, we cannot create an instance
        // of BonusMember. We can, however, create a new subclass of BonusMember, and
        // override the registerPoints()-method to just egister the points given
        // by the parameter.
        // Below, an anonymous class is created and instantiated, while overriding
        // the registerPoints()-method.

        this.bonusMember = new BasicMember(132, personals, LocalDate.of(2019, 4, 23));
        this.myLogger = new MyLogger();
    }

    @Test
    public void testCreatingInstanceWithValidData() {
        assertEquals(132, bonusMember.getMemberNo(), "Member number was incorrectly set. ");
        assertEquals(LocalDate.of(2019, 4, 23), bonusMember.getEnrolledDate(), "Incorret enrolled date. ");
        assertEquals("Odin", bonusMember.getPersonals().getFirstname(), "Incorrect first name. ");
        assertEquals("Kvarving", bonusMember.getPersonals().getSurname(), "Incorret surname. ");
        assertEquals("Odinkvarving@hotmail.com", bonusMember.getPersonals().getEmailAddress(), "Incorrect email adress. ");
        assertEquals(true, bonusMember.okPassword("banan"), "Incorrect password. ");

    }

    @Test
    public void findQualificationPoints() {
    this.bonusMember.addPoints(15000);

    assertEquals(15000, bonusMember.findQualificationPoints());
    assertEquals(-1, bonusMember.findQualificationPoints());
    }

    @Test
    public void okPassword() {
        assertTrue(this.bonusMember.okPassword("banan"));
        assertFalse(this.bonusMember.okPassword("Somethingelse"));
    }

    @Test
    public void registerPoints() {
        this.bonusMember.addPoints(10000);
        assertEquals(10000, this.bonusMember.getPoints());
    }

    @Test
    public void testRegisterPointsWithInvalidInput() {
        this.bonusMember.addPoints(-10000);
        assertEquals(0, this.bonusMember.getPoints());
    }

    @Test
    public void testInvalidParametersInConstructor(){
        try {
            BonusMember bm = new BasicMember(12, null, null);
            fail();
        } catch (Exception e){
            myLogger.getLogger().log(Level.FINE,e.getMessage());
            e.printStackTrace();
        }

        try {
            BonusMember bm = new BasicMember(-1, null, null);
            fail();
        } catch (Exception e) {
            myLogger.getLogger().log(Level.FINE, e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testAddingZeroPoints() {
        try {
            this.bonusMember.addPoints(0);
            fail();
        }
        catch (Exception e) {
            myLogger.getLogger().log(Level.FINE, e.getMessage());
            e.printStackTrace();
        }
    }
}