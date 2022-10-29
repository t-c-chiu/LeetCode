package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
	
	public static void main(String[] args) {
		List<Integer> res = goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2);
		System.out.println(res);
	}
	
	public static List<Integer> goodIndices(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		int[] decreasingFromLeft = new int[n], decreasingFromRight = new int[n];
		decreasingFromLeft[0] = 1;
		for (int i = 1; i < n; i++) {
			decreasingFromLeft[i] = nums[i] <= nums[i - 1] ? decreasingFromLeft[i - 1] + 1 : 1;
		}
		decreasingFromRight[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			decreasingFromRight[i] = nums[i] <= nums[i + 1] ? decreasingFromRight[i + 1] + 1 : 1;
		}
		for (int i = k; i < n - k; i++) {
			if (decreasingFromLeft[i - 1] >= k && decreasingFromRight[i + 1] >= k) {
				res.add(i);
			}
		}
		return res;
	}
}
