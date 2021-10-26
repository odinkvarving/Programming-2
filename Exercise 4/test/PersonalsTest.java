package no.ntnu.idata1001.oblig4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonalsTest {
    private Personals personals;

    @BeforeEach
    public void BeforeEach(){
        this.personals = new Personals("Odin", "Kvarving", "Odinkvarving@hotmail.com", "banan");
    }

    @Test
    public void testCreatingInstanceWithValidData() {
        assertEquals("Odin", this.personals.getFirstname());
        assertEquals("Kvarving", this.personals.getSurname());
        assertEquals("Odinkvarving@hotmail.com", this.personals.getEmailAddress());
        assertEquals("banan", this.personals.getPassword());
    }

    @Test
    public void testInvalidParametersInConstructor() {
        try {
            Personals testPersonals = new Personals("", "", "", "");
            fail();
        }
        catch (IllegalArgumentException e){
        }
    }

    @Test
    public void testChangePassword() {
        assertEquals(true, this.personals.changePassword("banan", "somethingelse"));
        assertEquals(false, this.personals.changePassword("wrongpassword", "somethingelse"));
    }
}
