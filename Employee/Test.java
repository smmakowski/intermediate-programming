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

public class Test {
  private Object[] year2014 = new Object[];
  private Object[] year2015 = new Object[];

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
}


public class CrimeTest {
	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
		// get start time for using program
		Date startTime = new Date();
		// if argument provided
		if (args.length > 0) {
			Crime crimeData = new Crime();
			try {
				// read the file data with Crime class method
				crimeData.readCrimeData(args[0]);
				crimeData.promptUser(); // prompt user for questions until response 'Q' using method

				Date endTime = new Date(); // get end time by instantiating new object

				int difference = (int)((endTime.getTime() - startTime.getTime()) / 1000L); // calculate difference using long type and explicitly case as int
				System.out.print("Thank you for trying the US Crimes Statistics Program.");
				System.out.println("Elapsed time in seconds: " + difference);

			} catch (FileNotFoundException e) {
				// exit; since read crime data has it's own handling and notification for exception
				System.exit(1);
			} catch (NumberFormatException e) {
				// exit since read crime data has own handling
			 	System.exit(1);
			} // no need for finally since scanner is closed inside of finally block of readFile method in Crime class
		} else { // if no argument provided
			// notify and exit
			System.out.println("No file path argument provided. Please run the program with the file path for the crime data as an argument (ex. java CrimeTest Crime.csv).");
			System.exit(1); // exit
		}
	}

  private static readData
}
