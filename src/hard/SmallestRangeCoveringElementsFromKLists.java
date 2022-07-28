package hard;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
	
	public static void main(String[] args) {
		int[] res = smallestRange(Arrays.asList(
				Arrays.asList(4, 10, 15, 24, 26),
				Arrays.asList(0, 9, 12, 20),
				Arrays.asList(5, 18, 22, 30)
		));
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] smallestRange(List<List<Integer>> nums) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		int n = nums.size();
		for (int i = 0; i < n; i++) {
			for (Integer num : nums.get(i)) {
				map.putIfAbsent(num, new ArrayList<>());
				map.get(num).add(i);
			}
		}
		int[] res = new int[]{map.firstKey(), map.lastKey()};
		int[] count = new int[n];
		List<Integer> list = new ArrayList<>(map.keySet());
		int l = 0, r = 0;
		while (l < list.size()) {
			while (r < list.size() && !allIn(count)) {
				for (Integer i : map.get(list.get(r))) {
					count[i]++;
				}
				r++;
			}
			if (allIn(count) && list.get(r - 1) - list.get(l) < res[1] - res[0]) {
				res = new int[]{list.get(l), list.get(r - 1)};
			}
			for (Integer i : map.get(list.get(l))) {
				count[i]--;
			}
			l++;
		}
		return res;
	}
	
	private static boolean allIn(int[] count) {
		for (int i : count) {
			if (i == 0) {
				return false;
			}
		}
		return true;
	}
}
