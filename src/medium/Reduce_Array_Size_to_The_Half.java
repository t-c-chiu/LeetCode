package medium;

import java.util.*;

public class Reduce_Array_Size_to_The_Half {
	
	public static void main(String[] args) {
		Reduce_Array_Size_to_The_Half test = new Reduce_Array_Size_to_The_Half();
		int res = test.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		System.out.println(res);
	}
	
	public int minSetSize(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		List<Integer> counts = new ArrayList<>(map.values());
		counts.sort(Comparator.reverseOrder());
		for (int i = 0, j = 0; i < counts.size(); i++) {
			j += counts.get(i);
			if (j >= arr.length / 2) {
				return i + 1;
			}
		}
		return 0;
	}
}
