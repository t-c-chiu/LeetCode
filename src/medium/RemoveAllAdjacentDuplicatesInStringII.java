package medium;

public class RemoveAllAdjacentDuplicatesInStringII {
	
	public static void main(String[] args) {
		String res = removeDuplicates("pbbcggttciiippooaais", 2);
		System.out.println(res);
	}
	
	public static String removeDuplicates(String s, int k) {
		int n = s.length();
		StringBuilder builder = new StringBuilder(s);
		int[] count = new int[n];
		for (int i = 0; i < builder.length(); i++) {
			if (i > 0 && builder.charAt(i) == builder.charAt(i - 1)) {
				count[i] = count[i - 1] + 1;
				if (count[i] == k) {
					builder.delete(i - k + 1, i + 1);
					i = i - k;
				}
			} else {
				count[i] = 1;
			}
		}
		return builder.toString();
	}
}
