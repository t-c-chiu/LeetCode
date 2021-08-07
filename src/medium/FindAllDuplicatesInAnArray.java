package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
	
	public static void main(String[] args) {
		List<Integer> res = findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
		System.out.println(res);
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				res.add(index + 1);
			} else {
				nums[index] = -nums[index];
			}
		}
		return res;
	}

//	public static List<Integer> findDuplicates(int[] nums) {
//		List<Integer> res = new ArrayList<>();
//		int n = nums.length;
//		int i = 0;
//		while (i < n) {
//			if (!swap(nums, i, nums[i] - 1)) {
//				i++;
//			}
//		}
//		for (int j = 0; j < n; j++) {
//			if (nums[j] != j + 1) {
//				res.add(nums[j]);
//			}
//		}
//		return res;
//	}
//
//	private static boolean swap(int[] nums, int i, int j) {
//		if (nums[i] == nums[j]) {
//			return false;
//		}
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//		return true;
//	}
}
