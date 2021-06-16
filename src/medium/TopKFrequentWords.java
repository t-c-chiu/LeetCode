package medium;

import java.util.*;

public class TopKFrequentWords {
	
	public static void main(String[] args) {
		List<String> res = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
		System.out.println(res);
	}
	
	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			count.put(words[i], count.getOrDefault(words[i], 0) + 1);
		}
		
		TreeMap<Integer, PriorityQueue<String>> map = new TreeMap<>();
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			String word = entry.getKey();
			Integer freq = entry.getValue();
			map.putIfAbsent(freq, new PriorityQueue<>());
			map.get(freq).offer(word);
		}
		
		List<String> res = new ArrayList<>();
		while (k > 0) {
			PriorityQueue<String> queue = map.pollLastEntry().getValue();
			while (k > 0 && !queue.isEmpty()) {
				res.add(queue.poll());
				k--;
			}
		}
		return res;
	}
}
