package easy;

import java.util.*;

public class MergeSimilarItems {
	
	public static void main(String[] args) {
	
	}
	
	public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] item : items1) {
			map.put(item[0], item[1]);
		}
		for (int[] item : items2) {
			map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
		}
		for (Integer value : map.keySet()) {
			res.add(Arrays.asList(value, map.get(value)));
		}
		res.sort(Comparator.comparingInt(list -> list.get(0)));
		return res;
	}
}
