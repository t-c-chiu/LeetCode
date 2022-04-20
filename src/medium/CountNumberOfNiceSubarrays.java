package medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
	
	public static void main(String[] args) {
		int res = numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
		System.out.println(res);
	}
	
	public static int numberOfSubarrays(int[] nums, int k) {
		int res = 0, count = 0, j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				k--;
				count = 0;
			}
			while (k == 0) {
				k += nums[j++] % 2;
				count++;
			}
			res += count;
		}
		return res;
	}
}
