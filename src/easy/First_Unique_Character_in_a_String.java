package easy;

public class First_Unique_Character_in_a_String {
	public static void main(String[] args) {
		First_Unique_Character_in_a_String test = new First_Unique_Character_in_a_String();
		System.out.println(test.firstUniqChar("leetcode"));
		System.out.println(test.firstUniqChar("loveleetcode"));
	}
	
	public int firstUniqChar(String s) {
		int[] frequency = new int[26];
		for (char c : s.toCharArray()) {
			frequency[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (frequency[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}
}
