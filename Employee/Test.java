/*
  Filename: Test.java
  Author: Stephen Makowski
  Date: March 19, 2018
  Purpose: Test class that contains main method. Main method reads employee
  information from 2014 and 2015 from a .txt file (assuming no more than 10
  employees per year and correct format), and then displays reports for both
  years containing original information and annual salary for each employee, and
  salary averages for the year.

  NOTE: This program is meant to be run in the command-line, and accepts one
  command-line argument: the path/name of the .txt file that you wish to read.
*/

import java.io.*;
import java.util.Scanner;

public class Test {
  private Object[] year2014 = new Object[10];
  private Object[] year2015 = new Object[10];

  public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
    if (args.length == 0) { // if no file has been provided notify and exit
      System.out.println("ERROR: No file path has been provided. Now exiting...");
      System.exit(0); // exit with error code 1
    }

    String filename = args[0];

    try {


    } catch (FileNotFoundException e) { // exception handling incorrect file path
      System.out.println("ERROR: The provided file is incorrect or does not exist." +
      " Please make sure that you provided a correct file path argument when running this program." +
      " Now exiting...");
      System.exit(0);
    } catch (NumberFormatException e) { // exception handinling for incorrect numbers during parsing
      System.out.println("ERROR: There was an error trying to parse one or more integers from '" +
      fileName + "'. Please correct any typos and ensure that data in individual" +
      "lines is separated by spaces.");
      System.exit(0);
    }
  }

  private static void readFile(String filename) {
    final String EMPTYSTRING = "";
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
  }

  private static void parseLine(String lineText) throws {
    String[] data = lineText.split(' ');
    try {
      // acquire data to pass into Employee (super
      int year = Integer.parseInt(data[0]);
      String class = data[1];
      String name  = formatName(data[2]); // format name with method and assign
      int monthlySalary = Integer.parseInt(data[3]);

      // depending on class parse extra data and create object
      if (class.equalsIgnoreCase("salesman")) {
        int stockPrice = Integer.parseInt(data[4]);

      } else if (class.equalsIgnoreCase("executive")) {
        //
      } else {

      }

      // insert into array based on year
    }
  }

  private void InsertIntoArray(int asdf, Object employee) {
    // depending on year insert into array by iterating through
    // and placing into first null slot

  }

  private static String formatName(String commaSeparatedName) {
    String[] nameArray = commaSeparatedName.split(',');
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
