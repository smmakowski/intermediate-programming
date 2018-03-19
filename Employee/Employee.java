/*
  Filename: Employee.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Employee base class declaration; superclass of Salesman and Exective classes. Contains private fields, constructor, and public methods.
*/

public class Employee {
  // private fields for base class
  private String name;
  private int monthlySalary; // in whole dollars

  // class constructor
  public Employee(String name, int monthlySalary) {
    this.name = name; // declare and assign from args (same for below)
    this.monthlySalary = salary;
  }

  // returns yearly salary
  public int annualSalary() {
    return this.salary * 12; // yearly salary = monthly * 12 months
  }

  // returns object string
  public String toString() {
      return "{" + "\"monthlySalary\":" + " " + this.monthlySalary + "\"name\":" + " " + this.name + "}"; // in JSON format
  }
}
