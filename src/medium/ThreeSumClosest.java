package medium;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public static void main(String[] args) {
		int res = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		System.out.println(res);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length, res = 0, diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 2; i++) {
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				int newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					diff = newDiff;
					res = sum;
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
