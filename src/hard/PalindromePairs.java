package hard;

import java.util.*;

public class PalindromePairs {
	
	public static void main(String[] args) {
		List<List<Integer>> res = palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll", "bbb", ""});
		System.out.println(res);
	}
	
	/**
	 * 1: a reverse == b - (a, b) (b, a)
	 * 2: a[0:i] is palindrome and b == a[i:]reversed - (b, a) - abacd, dc
	 * 3: a[i:] is palindrome and b == a[0:i]reversed - (a, b) - cdaba, dc
	 */
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			map.put(words[i], i);
		}
		if (map.containsKey("")) {
			int blankIdx = map.get("");
			for (int i = 0; i < n; i++) {
				if (isPalindrome(words[i]) && i != blankIdx) {
					res.add(Arrays.asList(blankIdx, i));
					res.add(Arrays.asList(i, blankIdx));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			String word = words[i];
			String rvs = reverse(word);
			if (map.containsKey(rvs) && map.get(rvs) != i) {
				res.add(Arrays.asList(i, map.get(rvs)));
			}
		}
		for (int i = 0; i < n; i++) {
			String word = words[i];
			for (int j = 1; j < word.length(); j++) {
				String s1 = word.substring(0, j);
				String s2 = word.substring(j);
				if (isPalindrome(s1)) {
					String s2rvs = reverse(s2);
					if (map.containsKey(s2rvs) && map.get(s2rvs) != i) {
						res.add(Arrays.asList(map.get(s2rvs), i));
					}
				}
				if (isPalindrome(s2)) {
					String s1rvs = reverse(s1);
					if (map.containsKey(s1rvs) && map.get(s1rvs) != i) {
						res.add(Arrays.asList(i, map.get(s1rvs)));
					}
				}
			}
		}
		return res;
	}
	
	private static boolean isPalindrome(String word) {
		int i = 0, j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	private static String reverse(String word) {
		return new StringBuilder(word).reverse().toString();
	}
}
