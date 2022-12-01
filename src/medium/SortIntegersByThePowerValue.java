package medium;

import java.util.*;

public class SortIntegersByThePowerValue {
	
	public static void main(String[] args) {
		int res = getKth(12, 15, 2);
		System.out.println(res);
	}
	
	public static int getKth(int lo, int hi, int k) {
		Map<Integer, Integer> cache = new HashMap<>();
		List<int[]> list = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			list.add(new int[]{i, transform(i, cache)});
		}
		list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		return list.get(k - 1)[0];
	}
	
	private static int transform(int i, Map<Integer, Integer> cache) {
		if (i == 1) {
			return 0;
		}
		if (cache.containsKey(i)) {
			return cache.get(i);
		}
		int step = 1;
		if (i % 2 == 0) {
			step += transform(i / 2, cache);
		} else {
			step += transform(3 * i + 1, cache);
		}
		cache.put(i, step);
		return step;
	}
}