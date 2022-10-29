package medium;

import java.util.*;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3}, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2}, 2)));
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] bucket = new List[nums.length + 1];
		for (Integer num : map.keySet()) {
			int count = map.get(num);
			if (bucket[count] == null) {
				bucket[count] = new ArrayList<>();
			}
			bucket[count].add(num);
		}
		int[] res = new int[k];
		for (int i = bucket.length - 1, j = 0; i > 0 && j < k; i--) {
			if (bucket[i] != null) {
				for (Integer num : bucket[i]) {
					res[j++] = num;
				}
			}
		}
		return res;
	}
}
