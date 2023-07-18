package registration;

/**
 * CS 5004
 * Fall 2023
 * Marian Padron
 * HW7 Person class.
 */
public class Person {
  private String name;
  private String address;

  /**
   * Constructor.
   * @param name String person name
   * @param address String person address
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Getter method for name.
   * @return String name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter method for address.
   * @return String address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * toString method.
   * @return String representation of person
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}
