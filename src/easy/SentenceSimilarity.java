package easy;

import java.util.*;

public class SentenceSimilarity {
	
	public static void main(String[] args) {
		boolean res = areSentencesSimilar(
				new String[]{"great", "acting", "skills"},
				new String[]{"fine", "drama", "talent"},
				Arrays.asList(
						Arrays.asList("great", "fine"),
						Arrays.asList("drama", "acting"),
						Arrays.asList("skills", "talent")
				));
		System.out.println(res);
	}
	
	public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
		if (sentence1.length != sentence2.length) {
			return false;
		}
		Map<String, Set<String>> map = new HashMap<>();
		for (List<String> similarPair : similarPairs) {
			String s1 = similarPair.get(0);
			String s2 = similarPair.get(1);
			map.putIfAbsent(s1, new HashSet<>());
			map.putIfAbsent(s2, new HashSet<>());
			map.get(s1).add(s2);
			map.get(s2).add(s1);
		}
		for (int i = 0; i < sentence1.length; i++) {
			String s1 = sentence1[i];
			String s2 = sentence2[i];
			if (s1.equals(s2) || map.get(s1) != null && map.get(s1).contains(s2)) {
				continue;
			}
			return false;
		}
		return true;
	}
}
