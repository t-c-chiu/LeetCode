package medium;

import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
	
	public static void main(String[] args) {
		int res = maxDistance(Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5),
				Arrays.asList(1, 2, 3)
		));
		System.out.println(res);
	}
	
	public static int maxDistance(List<List<Integer>> arrays) {
		List<Integer> list0 = arrays.get(0);
		int min = list0.get(0);
		int max = list0.get(list0.size() - 1);
		int res = 0;
		for (int i = 1; i < arrays.size(); i++) {
			List<Integer> list = arrays.get(i);
			Integer curMin = list.get(0);
			Integer curMax = list.get(list.size() - 1);
			res = Math.max(res, Math.abs(max - curMin));
			res = Math.max(res, Math.abs(curMax - min));
			max = Math.max(max, curMax);
			min = Math.min(min, curMin);
		}
		return res;
	}
}
