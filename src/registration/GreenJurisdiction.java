package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 GreenJurisdiction class.
 */
public class GreenJurisdiction implements IJurisdiction {

  private final double tax = .04;
  private final int additional = 100;

  /**
   * Calculate excise tax given an IVehicle.
   * @param vehicle IVehicle
   * @return double tax amount
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    return tax * vehicle.getPurchasePrice() + additional * vehicle.getMaxPassengers();
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "GreenJurisdiction function object";
  }

}
