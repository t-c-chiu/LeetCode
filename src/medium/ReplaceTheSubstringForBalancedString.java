package medium;

public class ReplaceTheSubstringForBalancedString {
	
	public static void main(String[] args) {
		int res = balancedString("QWER");
		System.out.println(res);
	}
	
	public static int balancedString(String s) {
		int[] count = new int[88];
		int length = s.length();
		for (int i = 0; i < length; i++) {
			count[s.charAt(i)]++;
		}
		int min = length / 4;
		int res = length;
		int left = 0;
		for (int right = 0; right < length; right++) {
			count[s.charAt(right)]--;
			while (left < length && count['Q'] <= min && count['W'] <= min && count['E'] <= min && count['R'] <= min) {
				res = Math.min(res, right - left + 1);
				count[s.charAt(left++)]++;
			}
		}
		return res;
	}
}
