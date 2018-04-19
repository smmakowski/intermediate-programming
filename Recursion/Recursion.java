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
    " and then print out the billionth number in the sequence to confirm identical results.");
    System.out.println("The runtime in miliseconds will then be printed for both for comparison.");

    System.out.println("Now running ITERATIVE Version...");
    Date iterativeStart = new Date();
    long iterativeResult = iterativeSequence(); //TODO
    Date iterativeEnd = new Date();
    long iterativeTime = iterativeEnd.getTime() - iterativeStart.getTime();
    System.out.println("iterativeResult: " + iterativeResult);
    System.out.println("iterativeTime: " + iterativeTime);

    System.out.println("Now running RECURSIVE Version...");
    Date recursiveStart = new Date();
    long recursiveResult = recursiveSequence(0L, 10000); //TODO
    Date recursiveEnd = new Date();
    long recursiveTime = recursiveEnd.getTime() - recursiveStart.getTime();
    System.out.println("iterativeResult: " + recursiveResult);
    System.out.println("iterativeTime: " + recursiveTime);
  }

  private static long iterativeSequence() {
    long result = 0L;
    for (int i = 0; i < 10000; i++) {
      result += 5;
    }

    return result;
  }

  private static long recursiveSequence(long n, int i) {
    if (i == 0) {
      return n;
    } else {
      return recursiveSequence(n + 5L, i - 1); // return
    }
  }
}
