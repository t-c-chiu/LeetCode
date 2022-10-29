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
		for (int i = 0; i < n; i++) {
			int left = i + 1, right = n - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < diff) {
					res = sum;
					diff = Math.abs(sum - target);
				}
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}
