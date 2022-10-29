package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int res = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(res);
	}
	
	public static int lengthOfLIS(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			if (list.isEmpty() || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				list.set(binarySearch(list, num), num);
			}
		}
		return list.size();
	}
	
	private static int binarySearch(List<Integer> list, int num) {
		int lo = 0, hi = list.size();
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (list.get(mid) < num) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
	
	
}
