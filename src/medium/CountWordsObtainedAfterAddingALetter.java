package medium;

import java.util.*;

public class CountWordsObtainedAfterAddingALetter {
	
	public static void main(String[] args) {
		int res = wordCount(new String[]{"ant", "act", "tack"}, new String[]{"tack", "act", "acti"});
		System.out.println(res);
	}
	
	public static int wordCount(String[] startWords, String[] targetWords) {
		int res = 0;
		Set<Integer> seen = new HashSet<>();
		for (String startWord : startWords) {
			seen.add(toInt(startWord));
		}
		for (String targetWord : targetWords) {
			int temp = toInt(targetWord);
			for (int i = 0; i < 26; i++) {
				if ((temp & (1 << (i))) > 0 && seen.contains(temp - (1 << (i)))) {
					res++;
					break;
				}
			}
		}
		return res;
	}
	
	private static int toInt(String word) {
		int temp = 0;
		for (int i = 0; i < word.length(); i++) {
			temp += 1 << (word.charAt(i) - 'a');
		}
		return temp;
	}
//	public static int wordCount(String[] startWords, String[] targetWords) {
//		int res = 0;
//		Map<Integer, Set<String>> map = new HashMap<>();
//		for (String startWord : startWords) {
//			char[] chars = startWord.toCharArray();
//			Arrays.sort(chars);
//			map.computeIfAbsent(startWord.length(), k -> new HashSet<>()).add(String.valueOf(chars));
//		}
//		for (String targetWord : targetWords) {
//			int length = targetWord.length();
//			char[] chars = targetWord.toCharArray();
//			Arrays.sort(chars);
//			targetWord = new String(chars);
//			for (int i = 0; i < length; i++) {
//				String temp = targetWord.substring(0, i) + targetWord.substring(i + 1);
//				if (map.containsKey(length - 1) && map.get(length - 1).contains(temp)) {
//					res++;
//					break;
//				}
//			}
//		}
//		return res;
//	}
}
