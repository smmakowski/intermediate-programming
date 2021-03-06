/*
  Filename: Employee.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Employee base class declaration; superclass of Salesman and Exective
  classes. Contains private fields, constructor, and public methods.
*/

public class Employee {
  // private fields for base class
  private String name;
  private int monthlySalary; // in whole dollars

  // class constructor
  public Employee(String name, int monthlySalary) {
    this.name = name; // declare and assign from args (same for below)
    this.monthlySalary = monthlySalary;
  }

  // returns yearly salary
  public int annualSalary() {
    return this.monthlySalary * 12; // yearly salary = monthly * 12 months
  }

  // returns object string
  public String toString() {
      return "{" + "\"name\": " + this.name + ", \"monthlySalary\": "
       + this.monthlySalary + "}"; // in JSON format
  }

  public String getName() {
    return this.name;
  }

  public String getClassName() {
    return "Employee";
  }
}
