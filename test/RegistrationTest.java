import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import registration.BlueJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Person;
import registration.Registration;
import registration.Vehicle;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 RegistrationTest class.
 */
public class RegistrationTest {
  private IRegistration registration;
  private IVehicle vehicle;
  private IJurisdiction jurisdiction;
  private int registrationYear;
  private List<Person> owners;
  private final double DELTA = 0;

  /**
   * Create IRegistration instance and parameter objects for testing.
   */
  @Before
  public void setup() {
    this.owners = new ArrayList<>();
    this.owners.add(new Person("Jane Doe", "123 Street"));
    this.owners.add(new Person("John Doe", "456 Avenue"));
    this.jurisdiction = new BlueJurisdiction();
    this.registrationYear = 2023;
    this.vehicle = new Vehicle("auto", "Kia", 2020, 23500);

    // Create registration for testing
    this.registration = new Registration(this.vehicle, this.jurisdiction,
            this.registrationYear, this.owners);
  }

  /**
   * Test getRegistrationYear().
   */
  @Test
  public void testGetRegistrationYear() {
    assertEquals(this.registrationYear, this.registration.getRegistrationYear(), DELTA);
  }

  /**
   * Test getProductionYear().
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2020, this.registration.getProductionYear(), DELTA);
  }

  /**
   * Test getJurisdiction().
   */
  @Test
  public void testGetJurisdiction() {
    assertEquals(this.jurisdiction, this.registration.getJurisdiction());
  }

  /**
   * Test getOwners().
   */
  @Test
  public void testGetOwners() {
    assertEquals(this.owners, this.registration.getOwners());
  }

  /**
   * Test getMaxPassengers().
   */
  @Test
  public void testGetMaxPassengers() {
    assertEquals(5, this.registration.getMaxPassengers(), DELTA);
  }

  /**
   * Test calculateExciseTax().
   */
  @Test
  public void testCalculateExciseTax() {
    assertEquals(705.00, this.registration.calculateExciseTax(), DELTA);
  }

  /**
   * Test toString().
   */
  @Test
  public void testToString() {
    assertEquals("Registration:\nAUTO: Kia Year(2020) Price = $23500.00"
            + "\nOwned By: Jane Doe, 123 Street; John Doe, 456 Avenue\nYear: 2023"
            + "\nExcise Tax: $705.00", this.registration.toString());
  }

  /**
   * Test equals().
   */
  @Test
  public void testEquals() {
    IRegistration other = new Registration(this.vehicle, this.jurisdiction,
            this.registrationYear, this.owners);
    assertTrue(this.registration.equals(other));

    IRegistration different = new Registration(this.vehicle, this.jurisdiction,
            2020, this.owners);
    assertFalse(this.registration.equals(different));

  }

}
