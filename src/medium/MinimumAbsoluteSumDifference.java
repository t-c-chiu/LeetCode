package medium;

import java.util.TreeSet;

public class MinimumAbsoluteSumDifference {
	
	public static void main(String[] args) {
		int res = minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4});
		System.out.println(res);
	}
	
	public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		long sum = 0;
		int maxDecrease = 0;
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int num : nums1) {
			treeSet.add(num);
		}
		for (int i = 0; i < nums1.length; i++) {
			int num1 = nums1[i];
			int num2 = nums2[i];
			int diff = Math.abs(num1 - num2);
			if (num1 != num2) {
				Integer ceiling = treeSet.ceiling(num2);
				Integer floor = treeSet.floor(num2);
				int minDiff = diff;
				if (ceiling != null) {
					minDiff = Math.min(minDiff, ceiling - num2);
				}
				if (floor != null) {
					minDiff = Math.min(minDiff, num2 - floor);
				}
				maxDecrease = Math.max(maxDecrease, diff - minDiff);
			}
			sum += diff;
		}
		return (int) ((sum - maxDecrease) % (1e9 + 7));
	}
}
