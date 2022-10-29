package medium;

import java.util.Arrays;

public class LargestNumber {
	
	public static void main(String[] args) {
		String res = largestNumber(new int[]{3, 30, 34, 5, 9});
		System.out.println(res);
	}
	
	public static String largestNumber(int[] nums) {
		int n = nums.length;
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strings, (a, b) -> -(a + b).compareTo(b + a));
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append(string);
		}
		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}
}
