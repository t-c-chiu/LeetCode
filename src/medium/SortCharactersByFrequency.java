package medium;

import java.util.*;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}
	
	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		List<Character>[] bucket = new ArrayList[s.length() + 1];
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Integer freq = entry.getValue();
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(entry.getKey());
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (Character c : bucket[i]) {
					for (int j = 0; j < i; j++) {
						builder.append(c);
					}
				}
			}
		}
		return builder.toString();
	}
}
