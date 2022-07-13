package medium;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public static void main(String[] args) {
		int res = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		System.out.println(res);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0, diff = Integer.MAX_VALUE, n = nums.length;
		for (int i = 0; i < n; i++) {
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r], newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					res = sum;
					diff = newDiff;
				}
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
		}
		return res;
	}
}
