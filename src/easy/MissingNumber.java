package easy;

import java.util.Arrays;

public class MissingNumber {
	
	public static void main(String[] args) {
		int res = missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
		System.out.println(res);
	}
	
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = Arrays.stream(nums).sum();
		return n * (n + 1) / 2 - sum;
	}
}
