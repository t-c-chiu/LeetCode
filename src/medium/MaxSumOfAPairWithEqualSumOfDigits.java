package medium;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {
	
	public static void main(String[] args) {
		int res = maximumSum(new int[]{18, 43, 36, 13, 7});
		System.out.println(res);
	}
	
	public static int maximumSum(int[] nums) {
		int res = -1, n = nums.length;
		int[] digitSum = new int[n];
		for (int i = 0; i < n; i++) {
			digitSum[i] = getDigitSum(nums[i]);
		}
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int sum = digitSum[i];
			map.putIfAbsent(sum, new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
			int[] max = map.get(sum);
			if (nums[i] > max[0]) {
				max[1] = max[0];
				max[0] = nums[i];
			} else if (nums[i] > max[1]) {
				max[1] = nums[i];
			}
		}
		for (int[] max : map.values()) {
			if (max[0] != Integer.MIN_VALUE && max[1] != Integer.MIN_VALUE) {
				res = Math.max(res, max[0] + max[1]);
			}
		}
		return res;
	}
	
	private static int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
