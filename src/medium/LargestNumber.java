package medium;

import java.util.Arrays;

public class LargestNumber {
	
	public static void main(String[] args) {
		String res = largestNumber(new int[]{3, 30, 34, 5, 9});
		System.out.println(res);
	}
	
	public static String largestNumber(int[] nums) {
		int n = nums.length;
		String[] numStr = new String[n];
		for (int i = 0; i < n; i++) {
			numStr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
		StringBuilder sb = new StringBuilder();
		for (String s : numStr) {
			sb.append(s);
		}
		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}
}
