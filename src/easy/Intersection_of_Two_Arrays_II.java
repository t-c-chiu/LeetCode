package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays_II {
	
	public static void main(String[] args) {
		Intersection_of_Two_Arrays_II test = new Intersection_of_Two_Arrays_II();
		
		for (int i : test.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : test.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) {
			System.out.print(i);
		}
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i : nums1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i : nums2) {
			if (map.containsKey(i) && map.get(i) > 0) {
				list.add(i);
				map.put(i, map.get(i) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
