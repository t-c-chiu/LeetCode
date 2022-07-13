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
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<>();
						list.add(map.get(str2rvs));
						list.add(i);
						res.add(list);
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					// check "str.length() != 0" to avoid duplicates
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(map.get(str1rvs));
						res.add(list);
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
