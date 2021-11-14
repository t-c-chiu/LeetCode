package medium;

public class ConstructKPalindromeStrings {
	
	public static void main(String[] args) {
		boolean res = canConstruct("annabelledz", 2);
		System.out.println(res);
	}
	
	/**
	 * annabelledz 2
	 * anelblena d z
	 */
	public static boolean canConstruct(String s, int k) {
		int n = s.length();
		if (n < k) {
			return false;
		}
		
		boolean[] odd = new boolean[26];
		for (int i = 0; i < n; i++) {
			int j = s.charAt(i) - 'a';
			odd[j] = !odd[j];
		}
		
		int oddCount = 0;
		for (boolean b : odd) {
			if (b) {
				oddCount++;
			}
		}
		return oddCount <= k;
	}
}
