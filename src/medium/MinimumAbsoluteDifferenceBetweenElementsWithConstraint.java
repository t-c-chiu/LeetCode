package medium;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
	
	public static void main(String[] args) {
		int res = minAbsoluteDifference(Arrays.asList(4, 3, 2, 4), 2);
		System.out.println(res);
	}
	
	public static int minAbsoluteDifference(List<Integer> nums, int x) {
		int n = nums.size(), res = Integer.MAX_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
		for (int l = 0, r = x; r < n; l++, r++) {
			int lNum = nums.get(l), rNum = nums.get(r);
			set.add(lNum);
			
			Integer floor = set.floor(rNum), ceiling = set.ceiling(rNum);
			if (floor != null) {
				res = Math.min(res, Math.abs(rNum - floor));
			}
			if (ceiling != null) {
				res = Math.min(res, Math.abs(rNum - ceiling));
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
