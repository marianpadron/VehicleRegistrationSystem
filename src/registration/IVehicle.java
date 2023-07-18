package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 IVehicle Interface.
 */
public interface IVehicle {

  /**
   * Getter method for vehicle kind.
   * @return String kind
   */
  String getKind();

  /**
   * Getter method for vehicle make.
   * @return String make
   */
  String getMake();

  /**
   * Getter method for vehicle production year.
   * @return int year
   */
  int getProductionYear();

  /**
   * Getter method for vehicle price.
   * @return int price
   */
  double getPurchasePrice();

  /**
   * Getter method for maxPassengers.
   * @return int
   */
  public int getMaxPassengers();
}
