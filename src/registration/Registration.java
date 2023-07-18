package registration;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW 7 Registration concrete class. Keeps registration info for a IVehicle.
 */
public class Registration implements IRegistration {
  private IVehicle vehicle;
  private int registrationYear;
  private int productionYear;
  private IJurisdiction jurisdiction;
  private List<Person> owners;

  /**
   * Constructor.
   * @param vehicle IVehicle being registered
   * @param jurisdiction IJurisdiction of vehicle
   * @param registrationYear int
   * @param owners List<Person></Person> that own the vehicle
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
                      List<Person> owners) {
    this.vehicle = vehicle;
    this.productionYear = vehicle.getProductionYear();
    this.jurisdiction = jurisdiction;
    this.registrationYear = registrationYear;
    this.owners = owners;
  }

  /**
   * Getter method for registration year.
   * @return int
   */
  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }

  /**
   * Getter method for production year.
   * @return int
   */
  @Override
  public int getProductionYear() {
    return this.productionYear;
  }

  /**
   * Getter method for jurisdiction.
   * @return IJurisdiction
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  /**
   * Getter method for vehicle owners.
   * @return List<Person></Person>
   */
  @Override
  public List<Person> getOwners() {
    return this.owners;
  }

  /**
   * Getter method for max passengers in vehicle.
   * @return int
   */
  @Override
  public int getMaxPassengers() {
    return this.vehicle.getMaxPassengers();
  }

  /**
   * Calculates excise tax depending on jurisdiction.
   * @return double
   */
  @Override
  public double calculateExciseTax() {
    return jurisdiction.exciseTax(this.vehicle);
  }

  /**
   * toString method for Registration.
   * @return String
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");

    // Format each part of the string
    String vehicle = this.vehicle.getKind() + ": " + this.vehicle.getMake();
    String vehicleYear = "Year(" + this.productionYear + ")";
    String price = "Price = $" + df.format(this.vehicle.getPurchasePrice());

    // Loop through owners list and add to string
    String owners = "Owned By: ";
    for (int i = 0; i < this.owners.size(); i++) {
      if (this.owners.size() != 1 && i < this.owners.size() - 1) {
        owners += this.owners.get(i) + "; ";
      } else {
        owners += this.owners.get(i);
      }
    }
    String registrationYear = "Year: " + this.registrationYear;
    String tax = "Excise Tax: $" + df.format(this.calculateExciseTax());

    // Return total string
    return "Registration:\n"
            + vehicle + " " + vehicleYear + " " + price + "\n"
            + owners + "\n"
            + registrationYear + "\n"
            + tax;
  }

  /**
   * hashCode() method.
   * @return int individual hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.vehicle, this.registrationYear, this.productionYear, this.owners);
  }

  /**
   * equals method for registration.
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

    Registration otherRegistration = (Registration) other;
    if (this.vehicle.equals(otherRegistration.vehicle)
            && this.registrationYear == otherRegistration.getRegistrationYear()
            && this.owners.equals(otherRegistration.getOwners())) {
      return true;
    }
    return false;
  }

}
