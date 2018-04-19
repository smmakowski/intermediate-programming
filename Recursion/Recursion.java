import java.io.*;

public class Recursion {
  public static void main(String[] args) {
    System.out.println("This program will create two identical sequences of numbers" +
    "using both ITERATIVE and RECURSIVE methods.");
    System.out.println("The sequence is multiples of 7.");
    System.out.println("For example, the first 10 numbers will be:");
    System.out.println("{7, 14, 21, 28, 35, 42, 49, 56, 63, 70}");
    System.out.println("Both ITERATIVE and RECURSIVE will go through the sequence," +
    " and then print out the 10000th number in the sequence to confirm identical results.");
    System.out.println("The runtime in miliseconds will then be printed for both for comparison.");

    System.out.println("Now running ITERATIVE Version...");
    Long iterativeStart = System.nanoTime();
    int iterativeResult = iterativeSequence(); //TODO
    Long iterativeEnd = System.nanoTime();
    long iterativeTime = iterativeEnd - iterativeStart;
    System.out.println("iterativeResult: " + iterativeResult);
    System.out.println("iterativeTime: " + iterativeTime);

    System.out.println("Now running RECURSIVE Version...");
    long recursiveStart = System.nanoTime();
    int recursiveResult = recursiveSequence(0, 10000); //TODO
    long recursiveEnd = System.nanoTime();
    long recursiveTime = recursiveEnd - recursiveStart;
    System.out.println("iterativeResult: " + recursiveResult);
    System.out.println("iterativeTime: " + recursiveTime);
  }

  private static int iterativeSequence() {
    int result = 0;
    for (int i = 0; i < 10000; i++) {
      result += 7;
    }

    return result;
  }

  private static int recursiveSequence(int n, int i) {
    if (i == 0) {
      return n;
    } else {
      return recursiveSequence(n + 7, i - 1); // return
    }
  }
}
