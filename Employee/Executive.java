/*
  Filename: Executive.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Executive class declaration; sub of Salesman and Employee class. Contains private fields, constructor, and public methods.
*/

public class Salesman extends Employee {
  // private fields unique to subclass
  private int stockPrice; // in whole dollars

  //class constructor
  public Executive(String name; int monthlySalary, int stockPrice) {
    super(name, monthlySalary); // call Executive super with name and monthlySalary
    this.stockPrice = stockPrice; // assign class-unique field
  }

  // annualSalary() overriden with same signature as Executive.annualSalary()
  public int annualSalary() {
    int baseSalary = super.annualSalary(); // declare/assign as return from super's .annualSalary() method
    int bonus = this.stockPrice > 50 ? 30000 : 0; // declare/assign bonus as 30000 (if stockPrice > 50) otherwise 0, with ternary

    return baseSalary + bonus; // return total annual salary
  }

  // toString() overridden with same signatute as super's .toString()
  public String toString() {
    String baseString = super.toString(); // call super's .toString() method
    return baseString + "\b, \"stockPrice\": " + this.stockPrice + "}"; // return baseString with additional properties ('\b' is used to delete the original ending bracket); JSON format
  }
}
