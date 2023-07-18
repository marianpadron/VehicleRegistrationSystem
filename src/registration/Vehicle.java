package registration;

import java.util.Objects;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW6 Vehicle class. Creates a type of IVehicle.
 */
public class Vehicle implements IVehicle {
  private String kind;
  private String make;
  private int productionYear;
  private double purchasePrice;
  private int maxPassengers;

  /**
   * Constructor.
   * @param kind String vehicle kind
   * @param make String vehicle make
   * @param productionYear int production year
   * @param purchasePrice double purchase price
   * @throws IllegalArgumentException checks valid parameters
   */
  public Vehicle(String kind, String make, int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    // Check valid parameters passed
    Vehicle.checkValidVehicle(kind, make, productionYear, purchasePrice);

    // Create vehicle
    this.kind = VehicleType.valueOf(kind.toUpperCase()).name();
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
    this.maxPassengers = VehicleType.valueOf(kind.toUpperCase()).getMaxPassengers();
  }

  /**
   * Static method to check valid parameters passed, will throw exception.
   * @param kind String vehicle kind
   * @param make String vehicle make
   * @param productionYear int production year
   * @param purchasePrice int purchase price
   * @throws IllegalArgumentException checks valid parameters
   */
  public static void checkValidVehicle(String kind, String make, int productionYear,
                                       double purchasePrice) throws IllegalArgumentException {
    // Check for valid kind
    if (kind == null || kind == "") {
      throw new IllegalArgumentException("Kind can't be empty.");
    }

    // Check for valid make
    if (make == null || make.isBlank()) {
      throw new IllegalArgumentException("Make must not be null or empty string.");
    }

    // Check for valid production year
    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Production year not valid.");
    }

    // Check for valid purchase price
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Invalid purchase price.");
    }

  }

  /**
   * Getter method for vehicle kind.
   * @return String kind
   */
  public String getKind() {
    return this.kind;
  }

  /**
   * Getter method for vehicle make.
   * @return String make
   */
  @Override
  public String getMake() {
    return this.make;
  }

  /**
   * Getter method for vehicle production year.
   * @return int year
   */
  @Override
  public int getProductionYear() {
    return this.productionYear;
  }

  /**
   * Getter method for vehicle price.
   * @return double price
   */
  @Override
  public double getPurchasePrice() {
    return this.purchasePrice;
  }

  /**
   * Getter method for maxPassengers.
   * @return int
   */
  public int getMaxPassengers() {
    return maxPassengers;
  }

  /**
   * hashCode() method.
   * @return int individual hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.kind, this.make, this.productionYear,
            this.purchasePrice, this.maxPassengers);
  }

  /**
   * equals method for vehicles.
   * @param other Object
   * @return boolean
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (other == null || this.getClass() != other.getClass()) {
      return false;
    }

    Vehicle otherVehicle = (Vehicle)other;
    if (this.kind.equals(otherVehicle.kind) && this.make.equals(otherVehicle.make)
            && this.productionYear == otherVehicle.productionYear
            && this.purchasePrice == otherVehicle.purchasePrice) {
      return true;
    }
    return false;
  }
}
