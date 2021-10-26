package no.ntnu.idata1001.oblig3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class SilverMemberTest {

  private Personals personals;
  private SilverMember silverMember;

  @BeforeEach
  public void beforeEach() {
    this.personals = new Personals("Jim", "Jones",
        "jim.jones@gmail.com", "MySecurePassword!");
    this.silverMember = new SilverMember(132, personals,
        LocalDate.of(2019, 4, 23), 0);
  }

  /**
   * Tests creation of an instance of BasicMember using valid
   * input data (positive test).
   */
  @Test
  public void testCreatingInstanceWithValidData() {

    // Verify that information was set correctly
    assertEquals(132, silverMember.getMemberNo(), "Member number was incorrectly set");
    assertEquals(LocalDate.of(2019, 4, 23), silverMember.getEnrolledDate(),
        "Incorrect enrolled date");
    assertEquals("Jim", silverMember.getPersonals().getFirstname(),
        "Incorrect first name.");
    assertEquals("Jones", silverMember.getPersonals().getSurname(),
        "Incorrect last name,");
    assertEquals("jim.jones@gmail.com", silverMember.getPersonals().getEMailAddress(),
        "Incorrect e-mail address.");
    assertEquals(true, silverMember.okPassword("MySecurePassword!"),
        "Incorrect password.");
  }

  /**
   * Tests if the registration of bonus points are handled correctly - POSITIVE test.
   */
  @Test
  public void registerPoints() {
    this.silverMember.registerPoints(10000);
    assertEquals(10000 * SilverMember.FACTOR_SILVER, this.silverMember.getPoints());
  }

  /**
   * Tests if the registration of bonus points are handled correctly,
   * if invalid input is given (negative points) - NEGATIVE test
   */
  @Test
  public void registerPointsWithInvalidInput() {
    this.silverMember.registerPoints(-10000);
    assertEquals(0, this.silverMember.getPoints());
  }

}