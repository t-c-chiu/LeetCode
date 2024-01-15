package easy;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
	
	public static void main(String[] args) {
		List<Integer> res = targetIndices(new int[]{1, 2, 5, 2, 3}, 2);
		System.out.println(res);
	}
	
	public static List<Integer> targetIndices(int[] nums, int target) {
		int less = 0, count = 0;
		for (int num : nums) {
			if (num == target) {
				count++;
			} else if (num < target) {
				less++;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = less; i < less + count; i++) {
			res.add(i);
		}
		return res;
	}
	
}
