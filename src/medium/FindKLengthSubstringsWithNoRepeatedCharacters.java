package medium;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
	
	public static void main(String[] args) {
		int res = numKLenSubstrNoRepeats("havefunonleetcode", 5);
		System.out.println(res);
	}
	
	public static int numKLenSubstrNoRepeats(String s, int k) {
		int n = s.length();
		if (k > n) {
			return 0;
		}
		int res = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0, j = 0; i < n; i++) {
			char c = s.charAt(i);
			while (set.contains(c)) {
				set.remove(s.charAt(j++));
			}
			set.add(c);
			if (i - j + 1 >= k) {
				res++;
			}
		}
		return res;
	}
}
