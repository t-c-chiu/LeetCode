package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
		System.out.println(topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3}, 2));
		System.out.println(topKFrequentElements.topKFrequent(new int[]{1, 2}, 2));
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>(k);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		List<Integer>[] lists = new ArrayList[nums.length + 1];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			List<Integer> list = lists[entry.getValue()];
			if (list == null) {
				list = new ArrayList<>();
				lists[entry.getValue()] = list;
			}
			list.add(entry.getKey());
		}
		
		for (int i = nums.length; i > 0 && k > 0; i--) {
			List<Integer> list = lists[i];
			if (list == null)
				continue;
			result.addAll(list);
			k -= list.size();
		}
		return result;
	}
}
