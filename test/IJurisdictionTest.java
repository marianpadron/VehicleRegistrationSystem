import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.RedJurisdiction;
import registration.Vehicle;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 IJurisdiction test class.
 */
public class IJurisdictionTest {
  private IJurisdiction blue;
  private IJurisdiction red;
  private IJurisdiction green;
  private IVehicle vehicle1;
  private IVehicle vehicle2;
  private final double DELTA = 0;

  /**
   * Create separate IJurisdiction instances for testing.
   */
  @Before
  public void setup() {
    blue = new BlueJurisdiction();
    red = new RedJurisdiction();
    green = new GreenJurisdiction();
    vehicle1 = new Vehicle("motorcycle", "Harley Davidson",
            1990, 12000);
    vehicle2 = new Vehicle("auto", "Kia", 2020, 23500);
  }

  /**
   * Tests exciseTax() for BlueJurisdiction.
   */
  @Test
  public void testBlueExciseTax() {
    assertEquals(blue.exciseTax(vehicle1), 459, DELTA);
    assertEquals(blue.exciseTax(vehicle2), 705, DELTA);
  }

  /**
   * Tests exciseTax() for RedJurisdiction.
   */
  @Test
  public void testRedExciseTax() {
    assertEquals(red.exciseTax(vehicle1), 600, DELTA);
    assertEquals(red.exciseTax(vehicle2), 1175, DELTA);
  }

  /**
   * Tests exciseTax() for BlueJurisdiction.
   */
  @Test
  public void testGreenExciseTax() {
    assertEquals(green.exciseTax(vehicle1), 680, DELTA);
    assertEquals(green.exciseTax(vehicle2), 1440, DELTA);
  }

  /**
   * Tests toString() for BlueJurisdiction.
   */
  @Test
  public void testBlueToString() {
    assertEquals("BlueJurisdiction function object", blue.toString());
  }

  /**
   * Tests toString() for RedJurisdiction.
   */
  @Test
  public void testRedToString() {
    assertEquals("RedJurisdiction function object", red.toString());
  }

  /**
   * Tests toString() for GreenJurisdiction.
   */
  @Test
  public void testGreenToString() {
    assertEquals("GreenJurisdiction function object", green.toString());
  }
}
