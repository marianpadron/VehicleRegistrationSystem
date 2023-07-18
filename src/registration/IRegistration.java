package registration;

import java.util.List;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW 7 IRegistration interface.
 */
public interface IRegistration {
  /**
   * Getter method for registration year.
   * @return int
   */
  public int getRegistrationYear();

  /**
   * Getter method for production year.
   * @return int
   */
  public int getProductionYear();

  /**
   * Getter method for jurisdiction.
   * @return IJurisdiction
   */
  public IJurisdiction getJurisdiction();

  /**
   * Getter method for vehicle owners.
   * @return List<Person></Person>
   */
  public List<Person> getOwners();      // return NON-MUTABLE list

  /**
   * Getter method for max passengers in vehicle.
   * @return int
   */
  public int getMaxPassengers();

  /**
   * Calculates excise tax depending on jurisdiction.
   * @return double
   */
  public double calculateExciseTax();
}
