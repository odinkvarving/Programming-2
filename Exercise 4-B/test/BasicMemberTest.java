package no.ntnu.idata1001.oblig3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass testing BasicMember.
 */
class BasicMemberTest {

  private Personals personals;
  private BasicMember basicMember;

  @BeforeEach
  public void beforeEach() {
    this.personals = new Personals("Jim", "Jones",
        "jim.jones@gmail.com", "MySecurePassword!");
    this.basicMember = new BasicMember(132, personals,
        LocalDate.of(2019, 4, 23));
  }

  /**
   * Tests creation of an instance of BasicMember using valid
   * input data (positive test).
   */
  @Test
  public void testCreatingInstanceWithValidData() {

    // Verify that information was set correctly
    assertEquals(132, basicMember.getMemberNo(), "Member number was incorrectly set");
    assertEquals(LocalDate.of(2019, 4, 23), basicMember.getEnrolledDate(),
        "Incorrect enrolled date");
    assertEquals("Jim", basicMember.getPersonals().getFirstname(),
        "Incorrect first name.");
    assertEquals("Jones", basicMember.getPersonals().getSurname(),
        "Incorrect last name,");
    assertEquals("jim.jones@gmail.com", basicMember.getPersonals().getEMailAddress(),
        "Incorrect e-mail address.");
    assertEquals(true, basicMember.okPassword("MySecurePassword!"),
        "Incorrect password.");
  }

  /**
   * Tests if the registration of bonus points are handled correctly - POSITIVE test.
   */
  @Test
  public void registerPoints() {
    this.basicMember.registerPoints(10000);
    assertEquals(10000, this.basicMember.getPoints());
  }

  /**
   * Tests if the registration of bonus points are handled correctly,
   * if invalid input is given (negative points) - NEGATIVE test
   */
  @Test
  public void registerPointsWithInvalidInput() {
    this.basicMember.registerPoints(-10000);
    assertEquals(0, this.basicMember.getPoints());
  }


}