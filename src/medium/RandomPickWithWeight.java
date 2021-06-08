package medium;

import java.util.Random;

public class RandomPickWithWeight {
	
	public static void main(String[] args) {
		Solution solution = new Solution(new int[]{1, 3});
		int oneCount = 0;
		int threeCount = 0;
		for (int i = 0; i < 100; i++) {
			int j = solution.pickIndex();
			if (j == 1) {
				oneCount++;
			} else {
				threeCount++;
			}
		}
		System.out.println(oneCount + ", " + threeCount);
	}
	
	static class Solution {
		int preSum[];
		int sum;
		
		public Solution(int[] w) {
			int n = w.length;
			preSum = new int[n];
			for (int i = 0; i < n; i++) {
				sum += w[i];
				preSum[i] = sum;
			}
		}
		
		
		public int pickIndex() {
			int target = new Random().nextInt(sum) + 1;
			int low = 0;
			int high = preSum.length;
			while (low < high) {
				int mid = low + (high - low) / 2;
				if (preSum[mid] < target) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			return low;
		}
	}
}
