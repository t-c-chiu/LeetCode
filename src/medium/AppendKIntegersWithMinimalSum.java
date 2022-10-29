package medium;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {
	
	public static void main(String[] args) {
		long res = minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35);
		System.out.println(res);
	}
	
	public static long minimalKSum(int[] nums, int k) {
		Arrays.sort(nums);
		int prev = -1;
		long res = (long) (k + 1) * k / 2;
		for (int num : nums) {
			if (num != prev && num <= k) {
				res -= num;
				res += ++k;
				prev = num;
			} else if (num > k) {
				break;
			}
		}
		return res;
	}
}
