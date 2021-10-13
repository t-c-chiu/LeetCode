package medium;

import java.util.Arrays;

public class MinimumElementsToAddToFormAGivenSum {
	
	public static void main(String[] args) {
		int res = minElements(new int[]{1, -10, 9, 1}, 100, 0);
		System.out.println(res);
	}
	
	public static int minElements(int[] nums, int limit, int goal) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (int) Math.ceil((double) Math.abs(goal - sum) / limit);
	}
	
//	public static int minElements(int[] nums, int limit, int goal) {
//		long sum = Arrays.stream(nums).mapToLong(x -> x).sum(), need = Math.abs(goal - sum);
//		return (int) Math.ceil((double) need / limit);
//	}
}
