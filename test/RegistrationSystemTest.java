import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;
import registration.RegistrationSystem;
import registration.Vehicle;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 RegistrationSystem test class.
 */
public class RegistrationSystemTest {

  private RegistrationSystem registrationSystem = null;
  private List<Person> owners;
  private IVehicle helperVehicle1;
  private IVehicle helperVehicle2;
  private final double DELTA = 0;

  /**
   * Get RegistrationSystem instance and initialize other objects for testing.
   */
  @Before
  public void setup() {
    registrationSystem = RegistrationSystem.getInstance();
    helperVehicle1 = new Vehicle("auto", "Kia", 2020, 23500);
    helperVehicle2 = new Vehicle("boat", "Skidoo", 2000, 12500);
    owners = new ArrayList<>();
    owners.add(new Person("Jane Doe", "123 Street"));
    owners.add( new Person("John Doe", "456 Avenue"));
  }

  /**
   * Test creation of a null IVehicle if pass invalid type.
   */
  @Test
  public void testNullVehicleCreation() {
    IVehicle test = registrationSystem.createVehicle("car", "Kia", 2020,
            23500);
    assertEquals(null, test);
  }

  /**
   * Tests correct illegal argument thrown if null kind passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNullKindVehicleCreation() {
    registrationSystem.createVehicle(null, "Kia", 2020, 23500);
  }

  /**
   * Tests correct illegal argument thrown if empty string kind passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEmptyKindVehicleCreation() {
    registrationSystem.createVehicle("", "Kia", 2020, 23500);
  }

  /**
   * Tests correct illegal argument thrown if null make passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNullMakeVehicleCreation() {
    registrationSystem.createVehicle("auto", null, 2020, 23500);
  }

  /**
   * Tests correct illegal argument thrown if empty string make passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEmptyMakeVehicleCreation() {
    registrationSystem.createVehicle("Auto", "", 2020, 23500);
  }

  /**
   * Tests correct illegal argument thrown if production year below 1900 passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBelowProductionYearVehicleCreation() {
    registrationSystem.createVehicle("auto", "Kia", 1899, 23500);
  }

  /**
   * Tests correct illegal argument thrown if production year above 2023 passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testAboveProductionYearVehicleCreation() {
    registrationSystem.createVehicle("auto", "Kia", 2024, 23500);
  }

  /**
   * Tests correct illegal argument thrown if negative purchase price passed to createVehicle().
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBadPurchasePriceVehicleCreation() {
    registrationSystem.createVehicle("auto", "Kia", 1899, -1);
  }

  /**
   * Tests createVehicle with valid parameters.
   */
  @Test
  public void testValidCreateVehicle() {
    IVehicle vehicle = registrationSystem.createVehicle("auto", "Kia",
            2020, 23500);
    assertTrue(vehicle.equals(helperVehicle1));
  }

  /**
   * Test getAllRegistrations() when empty.
   */
  @Test
  public void testGetEmptyAllRegistrations() {
    List<IRegistration> empty = registrationSystem.getAllRegistrations();
    assertTrue(empty.isEmpty());
  }

  /**
   * Test getAllRegistrations() returns unmodifiable list.
   */
  @Test (expected = UnsupportedOperationException.class)
  public void testUnmodifiableAllRegistrations() {
    List<IRegistration> empty = registrationSystem.getAllRegistrations();
    empty.add(new Registration(helperVehicle1, new BlueJurisdiction(), 2023, owners));
  }

  /**
   * Test register() of valid vehicle.
   */
  @Test
  public void testRegister() {
    IRegistration comparator = new Registration(helperVehicle1, new BlueJurisdiction(),
            2023, owners);
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);

    // check valid item added to list
    List<IRegistration> list = registrationSystem.getAllRegistrations();
    assertEquals(1, list.size(), DELTA);
    assertTrue(list.get(0).equals(comparator));
  }

  /**
   * Test register() of duplicate vehicle.
   */
  @Test
  public void testRegisterDuplicate() {
    // Add twice
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);

    // Check only one in list
    List<IRegistration> list = registrationSystem.getAllRegistrations();
    assertEquals(1, list.size(), DELTA);
    IRegistration comparator = new Registration(helperVehicle1, new BlueJurisdiction(),
            2023, owners);
    assertTrue(list.get(0).equals(comparator));
  }

  /**
   * Test getAllRegistrations() with items in list.
   */
  @Test
  public void testAllRegistrations() {
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2022, owners);
    List<IRegistration> list = registrationSystem.getAllRegistrations();
    assertEquals(2, list.size());
    assertTrue(!list.get(0).equals(list.get(1)));
  }

  /**
   * Test getFilteredList().
   */
  @Test
  public void testGetFilteredList() {
    // Add registrations
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2020, owners);

    // Make sure all items added
    assertEquals(3, registrationSystem.getAllRegistrations().size(), DELTA);

    // Filter list and check for correct values
    Predicate<IRegistration> query = q -> q.getRegistrationYear() == 2023;
    List<IRegistration> filtered = registrationSystem.getFilteredList(query);
    assertEquals(2, filtered.size(), DELTA);
    assertEquals(2023, filtered.get(0).getRegistrationYear(), DELTA);
    assertEquals(2023, filtered.get(1).getRegistrationYear(), DELTA);
  }

  /**
   * Test getFilteredList() returns unmodifiable list.
   */
  @Test (expected = UnsupportedOperationException.class)
  public void testGetFilteredListUnmodifiable() {
    // Add registrations
    Predicate<IRegistration> query = q -> q.getRegistrationYear() == 2023;
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2020, owners);

    // Try to modify list
    List<IRegistration> filtered = registrationSystem.getFilteredList(query);
    filtered.add(new Registration(helperVehicle2, new GreenJurisdiction(),
            1999, owners));
  }

  /**
   * Test reboot().
   */
  @Test
  public void testReboot() {
    // Add registrations
    Predicate<IRegistration> query = q -> q.getRegistrationYear() == 2023;
    registrationSystem.register(helperVehicle1, new BlueJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2023, owners);
    registrationSystem.register(helperVehicle2, new RedJurisdiction(), 2020, owners);

    // Check for correct list return
    assertEquals(3, registrationSystem.getAllRegistrations().size(), DELTA);
    registrationSystem.reboot();
    assertTrue(registrationSystem.getAllRegistrations().isEmpty());
  }

}
