package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW 7 IJurisdiction Interface.
 */
public interface  IJurisdiction {

  /**
   * Calculate excise tax given an IVehicle.
   * @param vehicle IVehicle
   * @return double tax amount
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}
