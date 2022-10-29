package easy;

public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram test = new ValidAnagram();
		System.out.println(test.isAnagram("anagram", "nagaram"));
		System.out.println(test.isAnagram("rat", "car"));
	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int n = s.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
