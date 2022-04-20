package medium;

import java.util.*;

public class SentenceSimilarityII {
	
	public static void main(String[] args) {
		boolean res = areSentencesSimilarTwo(
				new String[]{"I", "love", "leetcode"},
				new String[]{"I", "love", "onepiece"},
				Arrays.asList(
						Arrays.asList("manga", "onepiece"),
						Arrays.asList("platform", "anime"),
						Arrays.asList("leetcode", "platform"),
						Arrays.asList("anime", "manga")
				)
		);
		System.out.println(res);
	}
	
	public static boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
		if (sentence1.length != sentence2.length) {
			return false;
		}
		Map<String, String> map = new HashMap<>();
		for (List<String> pair : similarPairs) {
			String parent1 = find(map, pair.get(0));
			String parent2 = find(map, pair.get(1));
			if (!parent1.equals(parent2)) {
				map.put(parent1, parent2);
			}
		}
		for (int i = 0; i < sentence1.length; i++) {
			String s1 = sentence1[i];
			String s2 = sentence2[i];
			if (!s1.equals(s2) && !find(map, s1).equals(find(map, s2))) {
				return false;
			}
		}
		return true;
	}
	
	private static String find(Map<String, String> map, String s) {
		if (!map.containsKey(s)) {
			map.put(s, s);
		}
		String p = map.get(s);
		return s.equals(p) ? s : find(map, p);
	}

//	public static boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
//		if (sentence1.length != sentence2.length) {
//			return false;
//		}
//
//		Map<String, Set<String>> map = new HashMap<>();
//		for (List<String> similarPair : similarPairs) {
//			String s1 = similarPair.get(0);
//			String s2 = similarPair.get(1);
//			map.putIfAbsent(s1, new HashSet<>());
//			map.putIfAbsent(s2, new HashSet<>());
//			map.get(s1).add(s2);
//			map.get(s2).add(s1);
//		}
//		for (int i = 0; i < sentence1.length; i++) {
//			String s1 = sentence1[i];
//			String s2 = sentence2[i];
//			if (s1.equals(s2)) {
//				continue;
//			}
//			if (!map.containsKey(s1) || !isSimilar(s1, s2, map, new HashSet<>())) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private static boolean isSimilar(String source, String target, Map<String, Set<String>> map, Set<String> seen) {
//		if (map.get(source).contains(target)) {
//			return true;
//		}
//		seen.add(source);
//		for (String next : map.get(source)) {
//			if (!seen.contains(next) && isSimilar(next, target, map, seen)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
