package medium;

import java.util.*;

public class TopKFrequentWords {
	
	public static void main(String[] args) {
		List<String> res = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
		System.out.println(res);
	}
	
	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		List<String> res = new ArrayList<>();
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}
}
