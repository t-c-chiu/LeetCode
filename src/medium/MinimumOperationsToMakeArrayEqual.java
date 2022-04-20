package medium;

public class MinimumOperationsToMakeArrayEqual {
	
	public static void main(String[] args) {
		int res = minOperations(3);
		System.out.println(res);
	}
	
	/**
	 * 1 3 5
	 * 1 3 5 7
	 * 1 3 5 7 9
	 * 1 3 5 7 9 11
	 * n=3,2
	 * n=4,4
	 * n=5,6
	 */
	public static int minOperations(int n) {
		return n * n / 4;
	}
}
