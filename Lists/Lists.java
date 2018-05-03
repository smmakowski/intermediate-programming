/*
  Stephen Makowski
  Week 8 Discussion
  May 2, 2018
*/

import java.util.*;

public class Lists {
  public static void main(String[] args) {
    // weekday constants
    final String[] WEEKDAYS = new String[]{"Monday", "tuesday", "Wednesday", "Thursday", "Friday"};
    //create individual array lists for days
    ArrayList<ArrayList<String>> eatingRecords = new ArrayList<ArrayList<String>>();
    ArrayList<String> monday = new ArrayList<String>(Arrays.asList("Eggs", "Burger", "Pasta", "Dumplings", "chicken fried steak"));
    ArrayList<String> tuesday = new ArrayList<String>(Arrays.asList("pancakes", "Burger", "Arbys"));
    ArrayList<String> wednesday = new ArrayList<String>(Arrays.asList("Pizza", "Pizza", "Pizza", "Wings"));
    ArrayList<String> thursday = new ArrayList<String>(Arrays.asList("Soup"));
    ArrayList<String> friday = new ArrayList<String>(Arrays.asList("Eggs", "100 bagels"));
    // add to array list
    eatingRecords.add(monday);
    eatingRecords.add(tuesday);
    eatingRecords.add(wednesday);
    eatingRecords.add(thursday);
    eatingRecords.add(friday);
    // iterate through and print
    for (int j = 0; j < eatingRecords.size(); j++) {
      System.out.print(WEEKDAYS[j] + ": ");
      for (int l = 0; l < eatingRecords.get(j).size(); l++) {
        System.out.print(eatingRecords.get(j).get(l) + ", ");
      }
      System.out.print("\n");
    }
    // create and populate linked list from end
    LinkedList<Integer> line = new LinkedList<Integer>();

    for (int m = 0; m <= 20; m += 2) {
      line.add(m);
    }
    // remove and print from front
    while(line.size() > 0) {
      System.out.print(line.removeFirst() + ",");
    }

  }
}
