package medium;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsWithEqualDigitFrequency {
	
	
	public static void main(String[] args) {
		int res = equalDigitFrequency("12321");
		System.out.println(res);
	}
	
	public static int equalDigitFrequency(String s) {
		int n = s.length(), res = 0;
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int unique = 0, maxCount = 0;
			int[] count = new int[10];
			for (int j = i; j < n; j++) {
				char c = s.charAt(j);
				if (count[c - '0']++ == 0) {
					unique++;
				}
				maxCount = Math.max(maxCount, count[c - '0']);
				String sub = sb.append(c).toString();
				if (unique * maxCount == j - i + 1 && !seen.contains(sub)) {
					res++;
					seen.add(sub);
				}
			}
		}
		return res;
	}
}
