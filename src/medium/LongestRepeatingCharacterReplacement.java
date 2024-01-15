package medium;

public class LongestRepeatingCharacterReplacement {
	
	public static void main(String[] args) {
		int res = characterReplacement("ABAB", 2);
		System.out.println(res);
	}
	
	public static int characterReplacement(String s, int k) {
		int res = 0, max = 0;
		int[] count = new int[26];
		for (int l = 0, r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			count[c - 'A']++;
			if (count[c - 'A'] > max) {
				max = count[c - 'A'];
			}
			while (max + k < r - l + 1) {
				char lc = s.charAt(l++);
				count[lc - 'A']--;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
