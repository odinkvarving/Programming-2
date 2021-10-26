package no.ntnu.idata1001.oblig3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class BonusMemberTest {

  private Personals personals;
  private BonusMember bonusMember;

  @BeforeEach
  public void beforeEach() {
    this.personals = new Personals("Jim", "Jones",
        "jim.jones@gmail.com", "MySecurePassword!");

    // Now, since BonusMember is an abstract class, we cannot create an instance
    // of BonusMember. We can, however, create a new subclass of BonusMember, and
    // override the registerPoints()-method to just egister the points given
    // by the parameter.
    // Below, an anonymous class is created and instantiated, while overriding
    // the registerPoints()-method.
    this.bonusMember = new BonusMember(132, personals,
        LocalDate.of(2019, 4, 23)) {
      @Override
      public void registerPoints(int newPoints) {
        this.addPoints(newPoints);
      }
    };
  }

  /**
   * Tests creation of an instance of BasicMember using valid
   * input data (positive test).
   */
  @Test
  public void testCreatingInstanceWithValidData() {

    // Verify that information was set correctly
    assertEquals(132, bonusMember.getMemberNo(), "Member number was incorrectly set");
    assertEquals(LocalDate.of(2019, 4, 23), bonusMember.getEnrolledDate(),
        "Incorrect enrolled date");
    assertEquals("Jim", bonusMember.getPersonals().getFirstname(),
        "Incorrect first name.");
    assertEquals("Jones", bonusMember.getPersonals().getSurname(),
        "Incorrect last name,");
    assertEquals("jim.jones@gmail.com", bonusMember.getPersonals().getEMailAddress(),
        "Incorrect e-mail address.");
    assertEquals(true, bonusMember.okPassword("MySecurePassword!"),
        "Incorrect password.");
  }

  /**
   * Tests if the findQualificationPoints works correctly.
   * IF OK, this method should return the earned bonuspoints
   * if the member enrolled less than a year (365 days) since the
   * date provided.
   */
  @Test
  public void findQualificationPoints() {
    this.bonusMember.registerPoints(15000);

    // Test against a date less than 365 days ahead of enrollment date
    assertEquals(15000, this.bonusMember
        .findQualificationPoints(LocalDate.of(2020, 2, 26)));
    // Test against a date more than 365 days after date of enrollment.
    assertEquals(0, this.bonusMember
        .findQualificationPoints(LocalDate.of(2021, 2, 26)));

  }

  /**
   * Test that okPassword only acccepts the correct password.
   */
  @Test
  public void okPassword() {
    // Test that the method responds correctly to a correct password
    assertEquals(true, this.bonusMember.okPassword("MySecurePassword!"));
    // Test that the method responds correctly to a wrong/invalid password - NOT a negative test!!
    assertEquals(false, this.bonusMember.okPassword("WrongPassword"));
  }

  /**
   * Tests that the method okPassword() can deal with invalid input, which is NOT
   * the same as an invalid password. I.e. this is a NEGATIVE test.
   * <p>
   * Examples of invalid input:
   * <ul>
   *     <li>Empty string</li>
   *     <li><code>null</code></li>
   * </ul>
   */
  @Test
  public void okPasswordWithInvalidInput() {
    // Test that the method responds correctly to invalid input - empty string
    assertEquals(false, this.bonusMember.okPassword(""));
    // Test that the method responds correctly to invalid input - null
    assertEquals(false, this.bonusMember.okPassword(null));
  }

  /**
   * Tests if the registration of bonus points are handled correctly - POSITIVE test.
   */
  @Test
  public void registerPoints() {
    this.bonusMember.registerPoints(10000);
    assertEquals(10000, this.bonusMember.getPoints());
  }

  /**
   * Tests if the registration of bonus points are handled correctly,
   * if invalid input is given (negative points) - NEGATIVE test
   */
  @Test
  public void registerPointsWithInvalidInput() {
    this.bonusMember.registerPoints(-10000);
    assertEquals(0, this.bonusMember.getPoints());
  }

  @Test
  public void testInvalidParametersInConstructor(){
    try {
      BonusMember bm = new BasicMember(12, null, null);
      fail();
    } catch (IllegalArgumentException e){
    }
  }

}