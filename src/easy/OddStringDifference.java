package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddStringDifference {
	
	public static void main(String[] args) {
		String res = oddString(new String[]{"adc", "wzy", "abc"});
		System.out.println(res);
	}
	
	public static String oddString(String[] words) {
		int n = words[0].length();
		for (int i = 1; i < n; i++) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int j = 0; j < words.length; j++) {
				String word = words[j];
				int diff = word.charAt(i) - word.charAt(i - 1);
				map.putIfAbsent(diff, new ArrayList<>());
				map.get(diff).add(j);
			}
			if (map.size() == 2) {
				for (Integer diff : map.keySet()) {
					if (map.get(diff).size() == 1) {
						return words[map.get(diff).get(0)];
					}
				}
			}
		}
		return "";
	}
}
