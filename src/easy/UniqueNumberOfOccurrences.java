package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
	
	public static void main(String[] args) {
		boolean res = uniqueOccurrences(new int[]{1, 2, 2, 3, 3, 3});
		System.out.println(res);
	}
	
	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for (Integer count : map.values()) {
			if (!set.add(count)) {
				return false;
			}
		}
		return true;
	}
}
