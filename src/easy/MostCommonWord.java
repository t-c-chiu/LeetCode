package easy;

import java.util.*;

public class MostCommonWord {
	
	public static void main(String[] args) {
		String res = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
		System.out.println(res);
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("\\W");
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>(List.of(banned));
		for (String word : words) {
			if (!word.isEmpty() && !set.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		String res = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (res == null || entry.getValue() > map.get(res)) {
				res = entry.getKey();
			}
		}
		return res;
	}
}
