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
		int n = nums.length;
		List<Integer>[] bucket = new List[n + 1];
		for (Integer num : map.keySet()) {
			int freq = map.get(num);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(num);
		}
		int[] res = new int[k];
		for (int i = n, j = 0; i >= 1 && k > 0; i--) {
			if (bucket[i] != null) {
				for (Integer num : bucket[i]) {
					res[j++] = num;
				}
				k -= bucket[i].size();
			}
		}
		return res;
	}
}
