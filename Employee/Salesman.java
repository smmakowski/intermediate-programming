/*
  Filename: Salesman.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Executive class declaration; sub of Salesman and Employee class.
  Contains private fields, constructor, and public methods.
*/

public class Salesman extends Employee {
  // private fields unique to subclass
  private int annualSales; // in whole dollars

  //casll constructor
  public Salesman(String name, int monthlySalary, int annualSales) {
    super(name, monthlySalary); // call Executive super with name and monthlySalary
    this.annualSales = annualSales; // assign class-unique field
  }

  // annualSalary() overriden with same signature as Executive.annualSalary()
  public int annualSalary() {
    // declare/assign as return from super's .annualSalary() method
    int baseSalary = super.annualSalary();
     // declare/assign as 2% commission from annualSales [2% is 1/50th, thus division by 50]
    int commission = this.annualSales;

    return baseSalary + commission;// return
  }

  // toString() overridden with same signatute as super's .toString()
  public String toString() {
    String baseString = super.toString(); // call super's .toString() method
    // return baseString with additional properties ('\b' used to delete original ending bracket)
    return baseString + "\b, \"annualSales\": " + this.annualSales + "}";
  }

  public String getClassName() {
    return "Salesman";
  }
}
