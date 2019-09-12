package medium;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring(" "));
		System.out.println(test.lengthOfLongestSubstring("bbbbbb"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int[] cache = new int[256];
		for (int right = 0, left = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			cache[c]++;
			while (cache[c] > 1) {
				cache[s.charAt(left++)]--;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
