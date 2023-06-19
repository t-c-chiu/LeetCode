package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	
	public static void main(String[] args) {
		List<String> res = summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
		System.out.println(res);
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0, start = 0; i < n; i++) {
			if (i == n - 1 || nums[i + 1] != nums[i] + 1) {
				add(res, nums[start], nums[i]);
				start = i + 1;
			}
		}
		return res;
	}
	
	private static void add(List<String> res, int start, int end) {
		if (start == end) {
			res.add(String.valueOf(start));
		} else {
			res.add(start + "->" + end);
		}
	}
}
