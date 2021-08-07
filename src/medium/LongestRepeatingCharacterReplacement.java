package medium;

public class LongestRepeatingCharacterReplacement {
	
	public static void main(String[] args) {
		int res = characterReplacement("ABAB", 2);
		System.out.println(res);
	}
	
	public static int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int mostFreq = 0;
		int left = 0;
		int res = 0;
		for (int right = 0; right < s.length(); right++) {
			mostFreq = Math.max(mostFreq, ++count[s.charAt(right) - 'A']);
			int letterToChange = (right - left + 1) - mostFreq;
			if (letterToChange > k) {
				count[s.charAt(left) - 'A']--;
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
	
}
