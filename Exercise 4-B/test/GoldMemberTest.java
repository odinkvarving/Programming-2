package no.ntnu.idata1001.oblig3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the class GoldMember. Since the BonusMember-class
 */
class GoldMemberTest {

  private Personals personals;
  private GoldMember goldMember;

  @BeforeEach
  public void beforeEach() {
    this.personals = new Personals("Jim", "Jones",
        "jim.jones@gmail.com", "MySecurePassword!");
    this.goldMember = new GoldMember(132, personals,
        LocalDate.of(2019, 4, 23), 0);
  }

  /**
   * Tests creation of an instance of BasicMember using valid
   * input data (positive test).
   */
  @Test
  public void testCreatingInstanceWithValidData() {

    // Verify that information was set correctly
    assertEquals(132, goldMember.getMemberNo(), "Member number was incorrectly set");
    assertEquals(LocalDate.of(2019, 4, 23), goldMember.getEnrolledDate(),
        "Incorrect enrolled date");
    assertEquals("Jim", goldMember.getPersonals().getFirstname(),
        "Incorrect first name.");
    assertEquals("Jones", goldMember.getPersonals().getSurname(),
        "Incorrect last name,");
    assertEquals("jim.jones@gmail.com", goldMember.getPersonals().getEMailAddress(),
        "Incorrect e-mail address.");
    assertEquals(true, goldMember.okPassword("MySecurePassword!"),
        "Incorrect password.");
  }

  /**
   * Tests if the registration of bonus points are handled correctly - POSITIVE test.
   */
  @Test
  public void registerPoints() {
    this.goldMember.registerPoints(10000);
    assertEquals(10000 * GoldMember.FACTOR_GOLD, this.goldMember.getPoints());
  }

  /**
   * Tests if the registration of bonus points are handled correctly,
   * if invalid input is given (negative points) - NEGATIVE test
   */
  @Test
  public void registerPointsWithInvalidInput() {
    this.goldMember.registerPoints(-10000);
    assertEquals(0, this.goldMember.getPoints());
  }


}