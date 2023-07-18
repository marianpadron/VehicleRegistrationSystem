package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 VehicleType enum.
 */
public enum VehicleType {

  MOTORCYCLE(2),
  AUTO(5),
  BOAT(10);

  private final int maxPassengers;

  /**
   * Constructor.
   * @param maxPassengers int max passengers per vehicle type
   */
  VehicleType(int maxPassengers) {
    this.maxPassengers = maxPassengers;
  }

  /**
   * Getter method for maxPassengers.
   * @return int
   */
  public int getMaxPassengers() {
    return this.maxPassengers;
  }

}
