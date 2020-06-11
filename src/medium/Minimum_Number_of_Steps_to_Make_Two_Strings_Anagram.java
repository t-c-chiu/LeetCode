package medium;

public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
	
	public static void main(String[] args) {
		Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram test = new Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram();
		int res = test.minSteps("leetcode", "practice");
		System.out.println(res);
	}
	
	public int minSteps(String s, String t) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				res += count[i];
			}
		}
		return res;
	}
}
