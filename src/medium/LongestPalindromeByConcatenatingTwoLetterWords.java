package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {
	
	public static void main(String[] args) {
		int res = longestPalindrome(new String[]{"lc", "cl", "gg"});
		System.out.println(res);
	}
	
	public static int longestPalindrome(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		int res = 0;
		for (String word : words) {
			String target = "" + word.charAt(1) + word.charAt(0);
			if (map.containsKey(target)) {
				res += 4;
				map.put(target, map.get(target) - 1);
				map.remove(target, 0);
			} else {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		for (String s : map.keySet()) {
			if (s.charAt(0) == s.charAt(1)) {
				return res + 2;
			}
		}
		return res;
	}

//	public static int longestPalindrome(String[] words) {
//		Map<String, Integer> map = new HashMap<>();
//		for (String word : words) {
//			map.put(word, map.getOrDefault(word, 0) + 1);
//		}
//		int res = 0;
//		for (String s : map.keySet()) {
//			String target = "" + s.charAt(1) + s.charAt(0);
//			if (s.equals(target)) {
//				if (map.get(s) > 1) {
//					int count = map.get(s);
//					if (count % 2 == 1) {
//						count--;
//					}
//					res += count * 2;
//					map.put(s, map.get(s) - count);
//				}
//			} else {
//				if (map.containsKey(target) && map.get(target) > 0) {
//					int count = Math.min(map.get(s), map.get(target));
//					res += count * 4;
//					map.put(s, map.get(s) - count);
//					map.put(target, map.get(target) - count);
//				}
//			}
//		}
//		for (String s : map.keySet()) {
//			if (s.charAt(0) == s.charAt(1) && map.get(s) > 0) {
//				res += 2;
//				break;
//			}
//		}
//		return res;
//	}
}
