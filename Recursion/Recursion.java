import java.io.*;
import java.util.Date;

public class Recursion {
  public static void main(String[] args) {
    System.out.println("This program will create two identical sequences of numbers" +
    "using both ITERATIVE and RECURSIVE methods.");
    System.out.println("The sequence...");
    System.out.println("For example, the first 10 numbers will be:");
    System.out.println("{}");
    System.out.println("Both ITERATIVE and RECURSIVE will go through the sequence," +
    " and then print out the 10000th number in the sequence to confirm identical results.");
    System.out.println("The runtime in miliseconds will then be printed for both for comparison.");

    System.out.println("Now running ITERATIVE Version...");
    Date iterativeStart = new Date();
    int iterativeResult = iterativeSequence(); //TODO
    Date iterativeEnd = new Date();
    long iterativeTime = ((iterativeStart.getTime() - iterativeEnd.getTime()) / 1000L);
    System.out.println("iterativeResult: " + iterativeResult);
    System.out.println("iterativeTime: " + iterativeTime);

    System.out.println("Now running RECURSIVE Version...");
    Date recursiveStart = new Date();
    int recursiveResult = recursiveSequence(); //TODO
    Date recursiveEnd = new Date();
    long recursiveTime = ((recursiveStart.getTime() - recursiveEnd.getTime()) / 1000L);
    System.out.println("iterativeResult: " + recursiveResult);
    System.out.println("iterativeTime: " + recursiveTime);
  }

  private static int iterativeSequence() {
    int result = 0;
    for (int i = 0; i < 100000; i++) {

    }

    return 0;
  }

  private static int recursiveSequence() {
    if (true) {
      return 0;
    } else {
      return 0; // return
    }
  }
}
