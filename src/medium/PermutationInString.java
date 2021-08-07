package medium;

public class PermutationInString {
	
	public static void main(String[] args) {
		boolean res = checkInclusion("ab", "eidbaooo");
		System.out.println(res);
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		if (s1Len > s2Len) {
			return false;
		}
		
		int[] count = new int[26];
		for (int i = 0; i < s1Len; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		
		if (isAllZero(count)) {
			return true;
		}
		
		for (int i = s1Len; i < s2Len; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt(i - s1Len) - 'a']++;
			if (isAllZero(count)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isAllZero(int[] count) {
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
}
