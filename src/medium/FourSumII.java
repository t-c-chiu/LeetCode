package medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> abSum = new HashMap<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = A[i] + B[j];
				abSum.put(sum, abSum.getOrDefault(sum, 0) + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = C[i] + D[j];
				if (abSum.containsKey(-sum)) {
					res += abSum.get(-sum);
				}
			}
		}
		return res;
	}
}
