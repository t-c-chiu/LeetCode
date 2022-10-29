package medium;

import java.util.Random;

public class RandomPickWithWeight {
	
	public static void main(String[] args) {
		Solution solution = new Solution(new int[]{1, 3});
		int oneCount = 0;
		int threeCount = 0;
		for (int i = 0; i < 100; i++) {
			int j = solution.pickIndex();
			if (j == 0) {
				oneCount++;
			} else {
				threeCount++;
			}
		}
		System.out.println(oneCount + ", " + threeCount);
	}
	
	static class Solution {
		
		int[] w;
		int[] preSum;
		
		public Solution(int[] w) {
			this.w = w;
			int n = w.length;
			preSum = new int[n];
			preSum[0] = w[0];
			for (int i = 1; i < n; i++) {
				preSum[i] = preSum[i - 1] + w[i];
			}
		}
		
		public int pickIndex() {
			int n = preSum.length, target = new Random().nextInt(preSum[n - 1]) + 1, lo = 0, hi = n;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (preSum[mid] < target) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			return lo;
		}
	}
}
