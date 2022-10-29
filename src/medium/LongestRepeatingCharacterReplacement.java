package medium;

public class LongestRepeatingCharacterReplacement {
	
	public static void main(String[] args) {
		int res = characterReplacement("ABAB", 2);
		System.out.println(res);
	}
	
	public static int characterReplacement(String s, int k) {
		int res = 0, max = 0;
		int[] count = new int[26];
		for (int r = 0, l = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			max = Math.max(max, ++count[c - 'A']);
			if (r - l + 1 <= max + k) {
				res = Math.max(res, r - l + 1);
			} else {
				count[s.charAt(l++) - 'A']--;
			}
		}
		return res;
	}
}
