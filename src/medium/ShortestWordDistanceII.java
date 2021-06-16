package medium;

import java.util.*;

public class ShortestWordDistanceII {
	
	public static void main(String[] args) {
		WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		wordDistance.shortest("coding", "practice"); // return 3
		wordDistance.shortest("makes", "coding");    // return 1
	}
	
	static class WordDistance {
		
		Map<String, List<Integer>> map;
		
		public WordDistance(String[] wordsDict) {
			map = new HashMap<>();
			for (int i = 0; i < wordsDict.length; i++) {
				String word = wordsDict[i];
				map.putIfAbsent(word, new ArrayList<>());
				map.get(word).add(i);
			}
		}
		
		public int shortest(String word1, String word2) {
			List<Integer> word1Idx = map.get(word1);
			List<Integer> word2Idx = map.get(word2);
			int shortest = Integer.MAX_VALUE;
			int i = 0;
			int j = 0;
			while (i < word1Idx.size() && j < word2Idx.size()) {
				Integer i1 = word1Idx.get(i);
				Integer i2 = word2Idx.get(j);
				if (i1 < i2) {
					shortest = Math.min(shortest, i2 - i1);
					i++;
				} else {
					shortest = Math.min(shortest, i1 - i2);
					j++;
				}
			}
			return shortest;
		}
	}
}
