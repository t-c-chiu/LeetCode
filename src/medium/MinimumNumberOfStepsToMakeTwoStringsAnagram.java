package medium;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
	
	public static void main(String[] args) {
		int res = minSteps("leetcode", "practice");
		System.out.println(res);
	}
	
	public static int minSteps(String s, String t) {
		int n = s.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		int res = 0;
		for (int i : count) {
			if (i > 0) {
				res += i;
			}
		}
		return res;
	}
}
