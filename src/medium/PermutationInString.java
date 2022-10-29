package medium;

public class PermutationInString {
	
	public static void main(String[] args) {
		boolean res = checkInclusion("ab", "eidbaooo");
		System.out.println(res);
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		int m = s1.length(), n = s2.length(), diff = m;
		if (m > n) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < m; i++) {
			count[s1.charAt(i) - 'a']++;
		}
		for (int r = 0, l = 0; r < n; r++) {
			if (--count[s2.charAt(r) - 'a'] >= 0) {
				diff--;
			}
			if (r - l + 1 > m) {
				if (++count[s2.charAt(l++) - 'a'] > 0) {
					diff++;
				}
			}
			if (diff == 0) {
				return true;
			}
		}
		return false;
	}
}
