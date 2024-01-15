package medium;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int res = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
		System.out.println(res);
	}
	
	/**
	 * Quick Select
	 * 1. pick a num, put the smaller to its left and bigger to its right
	 * 2. check the num's index, if index == k, return num
	 * 3. recursive
	 */
	public static int findKthLargest(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		return findKthSmallest(list, list.size() - k + 1);
	}
	
	private static int findKthSmallest(List<Integer> list, int k) {
		int pivot = list.get(0), pivotCount = 0;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (Integer num : list) {
			if (num == pivot) {
				pivotCount++;
			} else if (num < pivot) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
		if (left.size() >= k) {
			return findKthSmallest(left, k);
		} else if (left.size() + pivotCount < k) {
			return findKthSmallest(right, k - left.size() - pivotCount);
		}
		return pivot;
	}
	
	
}
