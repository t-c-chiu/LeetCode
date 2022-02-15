package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	
	public static void main(String[] args) {
		WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		int res = wordDistance.shortest("coding", "practice");// return 3
		System.out.println(res);
		res = wordDistance.shortest("makes", "coding");    // return 1
		System.out.println(res);
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
			List<Integer> list1 = map.get(word1);
			List<Integer> list2 = map.get(word2);
			int res = Integer.MAX_VALUE, i = 0, j = 0;
			while (i < list1.size() && j < list2.size()) {
				int index1 = list1.get(i);
				int index2 = list2.get(j);
				res = Math.min(res, Math.abs(index1 - index2));
				if (index1 < index2) {
					i++;
				} else {
					j++;
				}
			}
			return res;
		}
	}
}
