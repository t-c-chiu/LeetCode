package medium;

public class PermutationInString {
	
	public static void main(String[] args) {
		boolean res = checkInclusion("ab", "eidbaooo");
		System.out.println(res);
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (m > n) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < m; i++) {
			count[s1.charAt(i) - 'a']++;
		}
		for (int r = 0, l = 0; r < n; r++) {
			count[s2.charAt(r) - 'a']--;
			if (r - l == m) {
				count[s2.charAt(l++) - 'a']++;
			}
			if (r - l + 1 == m && check(count)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean check(int[] count) {
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
}
