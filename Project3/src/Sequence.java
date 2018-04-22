

public class Sequence {
	private static int efficiency = 0;
	public static int computeIterative(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		
		
		int previous = 1;
		int result = 2;
		int temp;
		
		for (int i = 2; i < n; i++) {
			temp = result;
			result = (result * 2) + previous;
			previous = temp;
		}
		
		return result;
	}
	
	public static int computeRecursive(int n) {
		return nextSequence(1, 0, 1, n);
	}
	
	public static int getEfficiency() {
		return efficiency;
	}
	
	private static int nextSequence(int curr, int prev, int i, int max) {
		// handle edge cases 0 and 1
		if (max == 0) {
			return 0;
		} else if (max == 1) {
			return 1;
		}
		
		// recursive solution
		if (i == max) { // base case where i has reached max, return final number after calcualtiom
			return curr;
		} else { // recursive case, calculate next and call recursively.
			int result = (curr * 2) + prev;
			return nextSequence(result ,curr, i + 1, max);
		}
	}
}
