package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		SubarraySumEqualsK test = new SubarraySumEqualsK();
		final int ans = test.subarraySum(new int[]{1, 1, 1}, 2);
		System.out.println(ans);
	}
	
	/**
	 * sum存當前所有數字總和
	 * preSum, key -> 先前出現過的總和, value -> 該總和出現的次數
	 */
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k))
				count += preSum.get(sum - k);
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

//	public int subarraySum(int[] nums, int k) {
//		int ans = 0;
//		for (int i = 0; i < nums.length; i++) {
//			int sum = nums[i];
//			if (sum == k)
//				ans++;
//			for (int j = i + 1; j < nums.length; j++) {
//				sum += nums[j];
//				if (sum == k)
//					ans++;
//			}
//		}
//		return ans;
//	}
}
