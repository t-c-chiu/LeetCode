package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSwap {
	
	public static void main(String[] args) {
		int res = maximumSwap(10909091);
		System.out.println(res);
	}
	
	public static int maximumSwap(int num) {
		Map<Character, Integer> lastIndex = new HashMap<>();
		char[] chars = String.valueOf(num).toCharArray();
		int n = chars.length;
		for (int i = n - 1; i >= 0; i--) {
			char c = chars[i];
			lastIndex.putIfAbsent(c, i);
		}
		for (int i = 0; i < n; i++) {
			char c = chars[i];
			for (char k = '9'; k > c; k--) {
				if (lastIndex.containsKey(k) && lastIndex.get(k) > i) {
					swap(chars, i, lastIndex.get(k));
					return Integer.parseInt(String.valueOf(chars));
				}
			}
		}
		return num;
	}
	
	private static void swap(char[] chars, int i, Integer j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
