

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
		return 0;
	}
	
	public static int getEfficiency() {
		return efficiency;
	}
}
