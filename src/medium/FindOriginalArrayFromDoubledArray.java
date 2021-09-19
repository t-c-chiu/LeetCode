package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {
	
	public static void main(String[] args) {
		int[] res = findOriginalArray(new int[]{0, 0, 0, 0});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] findOriginalArray(int[] changed) {
		int n = changed.length;
		if (n % 2 == 1) {
			return new int[0];
		}
		
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i : changed) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int[] res = new int[n / 2];
		int i = 0;
		for (int num : map.keySet()) {
			int doubled = num * 2;
			if (map.get(num) > map.getOrDefault(doubled, 0)) {
				return new int[0];
			}
			for (int j = 0; j < map.get(num); j++) {
				res[i++] = num;
				map.put(doubled, map.get(doubled) - 1);
			}
		}
		return res;
	}
}
