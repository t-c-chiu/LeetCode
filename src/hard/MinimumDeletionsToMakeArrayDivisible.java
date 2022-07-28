package hard;

import java.util.Arrays;

public class MinimumDeletionsToMakeArrayDivisible {
	
	public static void main(String[] args) {
		int res = minOperations(new int[]{2, 3, 2, 4, 3}, new int[]{9, 6, 9, 3, 15});
		System.out.println(res);
	}
	
	public static int minOperations(int[] nums, int[] numsDivide) {
		Arrays.sort(nums);
		int gcd = getGcd(numsDivide);
		for (int i = 0; i < nums.length; i++) {
			if (gcd % nums[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	private static int getGcd(int[] numsDivide) {
		int gcd = numsDivide[0];
		for (int i = 1; i < numsDivide.length; i++) {
			gcd = gcd(gcd, numsDivide[i]);
		}
		return gcd;
	}
	
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
