package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 RedJurisdiction class.
 */
public class RedJurisdiction implements IJurisdiction {

  private final double tax = .05;

  /**
   * Calculate excise tax given an IVehicle.
   * @param vehicle IVehicle
   * @return double tax amount
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    return tax * vehicle.getPurchasePrice();
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "RedJurisdiction function object";
  }
}
