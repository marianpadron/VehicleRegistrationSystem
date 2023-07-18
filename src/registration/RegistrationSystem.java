package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 RegistrationSystem class. Keeps registration log of vehicles and their info.
 */
public class RegistrationSystem {

  private static final RegistrationSystem REGISTRATION_SYSTEM = new RegistrationSystem();
  private List<IRegistration> registrations = new ArrayList<>();

  /**
   * Private constructor.
   */
  private RegistrationSystem() {
  }

  /**
   * Get instance of registration system.
   * @return RegistrationSystem
   */
  public static RegistrationSystem getInstance() {
    return REGISTRATION_SYSTEM;
  }

  /**
   * Create IVehicle for RegistrationSystem.
   * @param kind String type of vehicle
   * @param make String make of vehicle
   * @param productionYear int year of production
   * @param purchasePrice double price of vehicle
   * @return IVehicle
   * @throws IllegalArgumentException checks valid parameters
   */
  public IVehicle createVehicle(String kind, String make,  int productionYear, double purchasePrice)
          throws  IllegalArgumentException {

    // Check valid parameters
    Vehicle.checkValidVehicle(kind, make, productionYear, purchasePrice);

    // Create IVehicle is valid kind
    List<String> vehicleTypes = Stream.of(VehicleType.values())
            .map(VehicleType::name).collect(Collectors.toList());
    if (vehicleTypes.contains(kind.toUpperCase())) {
      return new Vehicle(kind, make, productionYear, purchasePrice);
    }

    return null;
  }

  /**
   * Adds a new vehicle registration to the system, no duplicates allowed.
   * @param vehicle IVehicle
   * @param jurisdiction IJurisdiction
   * @param registrationYear int
   * @param owners List<Person></Person>
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
                       List<Person> owners) {
    // Create new registration
    IRegistration newRegistration = new Registration(vehicle, jurisdiction,
            registrationYear,owners);

    // Check each item in registrations list, for equal object
    for (IRegistration registration : this.registrations) {
      if (newRegistration.equals(registration)) {
        return;
      }
    }

    // If no identical item found, add to list
    this.registrations.add(newRegistration);

  }

  /**
   * Returns an unmodifiable list that contains all registrations in system.
   * @return List<IRegistration></IRegistration>
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(this.registrations);
  }

  /**
   * Returns a sublist of registrations filtered based on a query.
   * @param query Predicate<IRegistration></IRegistration>
   * @return List<IRegistration></IRegistration>
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    List<IRegistration> filtered = this.registrations.stream()
            .filter(r -> query.test(r)).collect(Collectors.toList());
    return Collections.unmodifiableList(filtered);
  }

  /**
   * Resets the state of the RegistrationSystem.
   */
  public void reboot() {
    this.registrations.clear();
  }

}
