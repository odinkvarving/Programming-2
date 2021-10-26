package no.ntnu.idatx2001.oblig5.zoo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Represents a male individual.
 */
class MaleIndividual extends Individual {

  /**
   * Creates an instance of MaleIndividual.
   *
   * @param norName     norwegian name of the animal
   * @param latName     the animal name in latin
   * @param latFamily   the family in latin
   * @param arrivalDate date of arrival to the Zoo
   * @param address     the address of the animal
   * @param name        the name of the individual
   * @param dateOfBirth date of birth
   * @param isDangerous <code>true</code> if dangerous for visitors
   */
  public MaleIndividual(String norName,
                        String latName,
                        String latFamily,
                        LocalDate arrivalDate,
                        String name,
                        LocalDate dateOfBirth,
                        boolean isDangerous,
                        String address) {

    super(norName, latName, latFamily, arrivalDate, name, dateOfBirth, isDangerous, address);
  }

  @Override
  public int getAge() {
    return (int) ChronoUnit.YEARS.between(getDateOfBirth(), LocalDate.now());
  }

  @Override
  public void move(String newAddress) {
    setAddress(newAddress);
  }

  @Override
  public String printInfo() {
    return toString();
  }
}
