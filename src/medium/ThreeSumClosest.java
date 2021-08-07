package medium;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public static void main(String[] args) {
		int res = threeSumClosest(new int[]{0, 1, 2}, 0);
		System.out.println(res);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				int newDiff = Math.abs(target - sum);
				if (newDiff < diff) {
					diff = newDiff;
					res = sum;
				}
				if (sum < target) {
					low++;
				} else {
					high--;
				}
			}
		}
		return res;
	}
}
