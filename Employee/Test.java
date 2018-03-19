/*
  Filename: Test.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Test class that contains main method. Main method reads employee
  information for the years 2014 and 2015 from a .txt file (assuming no more than 10
  employees per year and correct format), and then displays reports for both
  years containing original information and annual salary for each employee, and
  salary averages for the year.

  NOTE: This program is meant to be run in the command-line, and accepts one
  command-line argument: the path/name of the .txt file that you wish to read.
*/

import java.io.*;
import java.util.Scanner;

public class Test {
  private static Employee[] year2014 = new Employee[10];
  private static Employee[] year2015 = new Employee[10];

  public static void main(String[] args) {
    if (args.length == 0) { // if no file has been provided notify and exit
      System.out.println("ERROR: No file path has been provided. Now exiting...");
      System.exit(0); // exit with error code 1
    }

    String filename = args[0];

    // try {
    //   readFile(fileName); // read file
    // } catch (FileNotFoundException e) { // exception handling incorrect file path
    //   System.out.println("ERROR: The provided file is incorrect or does not exist." +
    //   " Please make sure that you provided a correct file path argument when running this program." +
    //   " Now exiting...");
    //   System.exit(0);
    // } catch (NumberFormatException e) { // exception handinling for incorrect numbers during parsing
    //   System.out.println("ERROR: There was an error trying to parse one or more integers from '" +
    //   fileName + "'. Please correct any typos and ensure that data in individual" +
    //   "lines is separated by spaces.");
    //   System.exit(0);
    // }
  }

  private static void readFile(String filename) throws FileNotFoundException{
    final String EMPTYSTRING = "";
    try {
      Scanner scan = new Scanner(new File(filename));
      String lineText = "";
      int i = 0;
      int j = 0;

      while (scan.hasNext()) {
        lineText = scan.nextLine();
        if (!lineText.equals(EMPTYSTRING)) {
          parseLine(lineText);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: The provided file is incorrect or does not exist." +
      " Please make sure that you provided a correct file path argument when running this program." +
      " Now exiting...");
      System.exit(0);
    }

  }

  private static void parseLine(String lineText) throws NumberFormatException{
    String[] data = lineText.split(" ");
    Employee employee = null;
    try {
      // acquire data to pass into Employee (super
      int year = Integer.parseInt(data[0]);
      String className = data[1];
      String name  = formatName(data[2]); // format name with method and assign
      int monthlySalary = Integer.parseInt(data[3]);

      // depending on className parse extra data and create object and assign to object
      if (className.equalsIgnoreCase("salesman")) {
        int annualSales = Integer.parseInt(data[4]);
        employee = new Salesman(name, monthlySalary, annualSales);
      } else if (className.equalsIgnoreCase("executive")) {
        int stockPrice = Integer.parseInt(data[4]);
        employee = new Executive(name, monthlySalary, stockPrice);
      } else {
        employee = new Employee(name, monthlySalary);
      }

      insertIntoArray(year, employee);
    } catch (NumberFormatException e) {
      System.out.println("ERROR: There was an error trying to parse one or more integers from .txt file" +
      ". Please correct any typos and ensure that data in individual" +
      "lines is separated by spaces.");
      System.exit(0);
    }
  }

  private static void insertIntoArray(int year, Employee employee) {
    final int ARRAYLENGTH = 10; // set array lenght constant

    // depending on year append to different arrays
    if (year == 2014) {
      if (!year2014[9].equals(null)) { // something is in last slot
        System.out.println("WARNING: Data slots for 2014 are full. User, " + employee.getName() + ", will not" +
        " be added.");
      }
      // iterate through array
      for (int i = 0; i < ARRAYLENGTH; i++) {
        if (year2014[i].equals(null)) { // upon first empty spot
          year2014[i] = employee; // assign
          break; // exit loop
        }
      }
    } else if (year == 2015) {
      for (int i = 0; i < ARRAYLENGTH; i++) {
        if (year2015[i].equals(null)) {
          year2015[i] = employee;
          break;
        }
      }
    } else { // if not a valid year, notify user
      System.out.println("WARNING: Employee, " + employee.getName() + "'s record is not from a valid" +
      "year. Record will not be added.");
    }
  }

  private static String formatName(String commaSeparatedName) {
    String[] nameArray = commaSeparatedName.split(",");
    String formattedName;
    if (nameArray.length == 2) { // if last,first name
      formattedName = nameArray[1] + " " + nameArray[0]; // arrange into <first> <last> format
    } else { // if no commas, ex. if name is just 'Drake', 'Adel', 'Batman', etc.
        formattedName = nameArray[0]; // set formatted name as is
    }

    return formattedName;
  }

  private static void printReport(int year) {

  }

}
