package easy;

public class RemoveLetterToEqualizeFrequency {
	
	public static void main(String[] args) {
		boolean res = equalFrequency("abc");
		System.out.println(res);
	}
	
	public static boolean equalFrequency(String word) {
		int[] count = new int[26];
		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a']++;
		}
		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a']--;
			if (allEqual(count)) {
				return true;
			}
			count[word.charAt(i) - 'a']++;
		}
		return false;
	}
	
	private static boolean allEqual(int[] count) {
		int freq = -1;
		for (int i : count) {
			if (i == 0) {
				continue;
			}
			if (freq == -1) {
				freq = i;
			}
			if (freq != i) {
				return false;
			}
		}
		return true;
	}
}
