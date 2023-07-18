package registration;

/**
 * CS 5004
 * Fall 2023
 * HW7 Blue Jurisdiction class.
 */
public class BlueJurisdiction implements IJurisdiction {
  private final double tax = .03;
  private final int additional = 99;

  /**
   * Calculate excise tax given an IVehicle.
   * @param vehicle IVehicle
   * @return double tax amount
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    if (vehicle.getProductionYear() < 2000) {
      return this.tax * vehicle.getPurchasePrice() + this.additional;
    }
    return this.tax * vehicle.getPurchasePrice();
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "BlueJurisdiction function object";
  }

}
