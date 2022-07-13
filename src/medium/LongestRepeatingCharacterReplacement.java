package medium;

public class LongestRepeatingCharacterReplacement {
	
	public static void main(String[] args) {
		int res = characterReplacement("ABAA", 0);
		System.out.println(res);
	}
	
	public static int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int res = 0, max = 0;
		for (int right = 0, left = 0; right < s.length(); right++) {
			int j = s.charAt(right) - 'A';
			count[j]++;
			max = Math.max(max, count[j]);
			if (right - left + 1 > k + max) {
				count[s.charAt(left++) - 'A']--;
			} else {
				res = Math.max(res, right - left + 1);
			}
		}
		return res;
	}
}
