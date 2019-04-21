package easy;

public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram test = new ValidAnagram();
		System.out.println(test.isAnagram("anagram", "nagaram"));
		System.out.println(test.isAnagram("rat", "car"));
	}
	
	public boolean isAnagram(String s, String t) {
		char[] chars = new char[26];
		for (char c : s.toCharArray())
			chars[c - 'a']++;
		for (char c : t.toCharArray())
			chars[c - 'a']--;
		for (int i : chars)
			if (i != 0)
				return false;
		return true;
	}
}
