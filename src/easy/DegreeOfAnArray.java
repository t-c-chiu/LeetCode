package easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
	
	public static void main(String[] args) {
		int res = findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
		System.out.println(res);
	}
	
	public static int findShortestSubArray(int[] nums) {
		int n = nums.length, res = 0, maxFreq = 0;
		Map<Integer, Integer> freq = new HashMap<>();
		Map<Integer, Integer> start = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			freq.put(num, freq.getOrDefault(num, 0) + 1);
			start.putIfAbsent(num, i);
			int f = freq.get(num);
			if (f > maxFreq) {
				maxFreq = f;
				res = i - start.get(num) + 1;
			} else if (f == maxFreq) {
				res = Math.min(res, i - start.get(num) + 1);
			}
		}
		return res;
	}
}
