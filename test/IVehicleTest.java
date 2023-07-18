import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import registration.IVehicle;
import registration.Vehicle;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 IVehicle objects test class.
 */
public class IVehicleTest {

  private IVehicle auto;
  private IVehicle motorcycle;
  private IVehicle boat;
  private final double DELTA = 0;

  /**
   * Create three IVehicle instances for testing.
   */
  @Before
  public void setup() {
    this.auto = new Vehicle("auto", "Kia", 2020, 23500);
    this.boat = new Vehicle("boat", "Skidoo", 2000, 12500);
    this.motorcycle = new Vehicle("motorcycle", "Harley Davidson",
            1990, 12000);
  }

  /**
   * Test bad construction with empty kind parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyKind() {
    IVehicle vehicle = new Vehicle("", "Kia", 2020, 23500);
  }

  /**
   * Test bad construction with null kind parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullKind() {
    IVehicle vehicle = new Vehicle(null, "Kia", 2020, 23500);
  }

  /**
   * Test bad construction with empty make parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyMake() {
    IVehicle vehicle = new Vehicle("auto", "", 2020, 23500);
  }

  /**
   * Test bad construction with null make parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullMake() {
    IVehicle vehicle = new Vehicle("auto", null, 2020, 23500);
  }

  /**
   * Test bad construction with production year below 1900.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testProductionYearBelow() {
    IVehicle vehicle = new Vehicle("auto", "Kia", 1899, 23500);
  }

  /**
   * Test bad construction with production year above 2023.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testProductionYearAbove() {
    IVehicle vehicle = new Vehicle("auto", "Kia", 2024, 23500);
  }

  /**
   * Test bad construction with invalid purchase price.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPrice() {
    IVehicle vehicle = new Vehicle("auto", "Kia", 2020, -1);
  }

  /**
   * Tests getKind().
   */
  @Test
  public void testGetKind() {
    assertEquals("AUTO", this.auto.getKind());
    assertEquals("BOAT", this.boat.getKind());
    assertEquals("MOTORCYCLE", this.motorcycle.getKind());
  }

  /**
   * Tests getMake().
   */
  @Test
  public void testGetMake() {
    assertEquals("Kia", this.auto.getMake());
    assertEquals("Skidoo", this.boat.getMake());
    assertEquals("Harley Davidson", this.motorcycle.getMake());
  }

  /**
   * Tests getProductionYear().
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2020, this.auto.getProductionYear(), DELTA);
    assertEquals(2000, this.boat.getProductionYear(), DELTA);
    assertEquals(1990, this.motorcycle.getProductionYear(), DELTA);
  }

  /**
   * Tests getPurchasePrice().
   */
  @Test
  public void testGetPurchasePrice() {
    assertEquals(23500, this.auto.getPurchasePrice(), DELTA);
    assertEquals(12500, this.boat.getPurchasePrice(), DELTA);
    assertEquals(12000, this.motorcycle.getPurchasePrice(), DELTA);
  }

  /**
   * Tests getMaxPassengers().
   */
  @Test
  public void testGetMaxPassengers() {
    assertEquals(5, this.auto.getMaxPassengers(), DELTA);
    assertEquals(10, this.boat.getMaxPassengers(), DELTA);
    assertEquals(2, this.motorcycle.getMaxPassengers(), DELTA);
  }

  /**
   * Tests equals().
   */
  @Test
  public void testEquals() {
    // Test same vehicles
    IVehicle otherAuto = new Vehicle("auto", "Kia", 2020, 23500);
    IVehicle otherBoat = new Vehicle("boat", "Skidoo", 2000,
            12500);
    IVehicle otherMotorcycle = new Vehicle("motorcycle", "Harley Davidson",
            1990, 12000);

    assertTrue(this.auto.equals(otherAuto));
    assertTrue(this.boat.equals(otherBoat));
    assertTrue(this.motorcycle.equals(otherMotorcycle));

    // Test different vehicles
    IVehicle diffAuto = new Vehicle("auto", "Kia", 2021, 23500);
    IVehicle diffBoat = new Vehicle("boat", "Skidoo", 2000,
            12000);
    IVehicle diffMotorcycle = new Vehicle("motorcycle", "Harley",
            1990, 12000);
    assertFalse(this.auto.equals(diffAuto));
    assertFalse(this.boat.equals(diffBoat));
    assertFalse(this.motorcycle.equals(diffMotorcycle));
    assertFalse(this.auto.equals(this.boat));
    assertFalse(this.boat.equals(this.motorcycle));
    assertFalse(this.motorcycle.equals(this.auto));
  }

}
