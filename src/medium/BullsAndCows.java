package medium;

public class BullsAndCows {
	
	public static void main(String[] args) {
		String res = getHint("1123", "0111");
		System.out.println(res);
	}
	
	public static String getHint(String secret, String guess) {
		int n = secret.length(), bull = 0, cow = 0;
		int[] count1 = new int[10];
		int[] count2 = new int[10];
		for (int i = 0; i < n; i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 == c2) {
				bull++;
			} else {
				count1[c1 - '0']++;
				count2[c2 - '0']++;
			}
		}
		for (int i = 0; i < 10; i++) {
			cow += Math.min(count1[i], count2[i]);
		}
		return "" + bull + 'A' + cow + 'B';
	}
}
