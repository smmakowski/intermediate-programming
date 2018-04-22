/*
 * Filename: Sequence.java
 * Author: Stephen Makowski
 * Date: April 22, 2018
 * Purpose: Methods for calculating nth term in sequence (iterative and recursive), and efficiency counter/return
*/

public class Sequence {
	private static int efficiency = 0; // efficiency counter
	
	public static int computeIterative(int n) {
		efficiency = 0; // init efficiency at 0
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		
		
		int previous = 1;
		int result = 2;
		int temp;
		
		for (int i = 2; i < n; i++) {
			efficiency += 1; // increase efficiency for every iteration of loop
			temp = result;
			result = (result * 2) + previous;
			previous = temp;
		}
		
		return result;
	}
	
	public static int computeRecursive(int n) {
		efficiency = 0; // init efficiency as 0;
		// if 0th or 1st number in sequence just return since no need to recurse for calcuation
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		
		return nextSequence(1, 0, 1, n);
	}
	
	public static int getEfficiency() {
		return efficiency; // returns efficiency
	}
	
	private static int nextSequence(int curr, int prev, int i, int max) {
		efficiency += 1;// increment efficiency for eachfunction call
		// recursive solution
		if (i == max) { // base case where i has reached max, return final number after calcualtiom
			return curr;
		} else { // recursive case, calculate next and call recursively.
			int result = (curr * 2) + prev;
			return nextSequence(result ,curr, i + 1, max);
		}
	}
}
