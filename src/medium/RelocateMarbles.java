package medium;

import java.util.*;

public class RelocateMarbles {
	
	public static void main(String[] args) {
		List<Integer> res = relocateMarbles(new int[]{1, 6, 7, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5});
		System.out.println(res);
	}
	
	public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int n = moveFrom.length;
		for (int i = 0; i < n; i++) {
			int from = moveFrom[i], to = moveTo[i];
			Integer count = map.get(from);
			map.remove(from);
			map.put(to, map.getOrDefault(to, 0) + count);
		}
		List<Integer> res = new ArrayList<>(map.keySet());
		res.sort(Comparator.naturalOrder());
		return res;
	}
	
}
