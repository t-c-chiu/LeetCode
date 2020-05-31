package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {
	public static void main(String[] args) {
		Arrays.stream(new RelativeSortArray()
				.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}))
				.forEach(System.out::print);
	}

	// 2,2,2,1,4,3,3,9,6,7,19
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new TreeMap<>();
		int[] result = new int[arr1.length];
		int idx = 0;
		for (int i : arr1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i : arr2) {
			Integer count = map.remove(i);
			while (count-- > 0)
				result[idx++] = i;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer count = entry.getValue();
			while (count-- > 0)
				result[idx++] = key;
		}
		return result;
	}
}
