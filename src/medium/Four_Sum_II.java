package medium;

import java.util.HashMap;
import java.util.Map;

public class Four_Sum_II {
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		Map<Integer, Integer> absum = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				absum.put(A[i] + B[j], absum.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				count += absum.getOrDefault(-(C[i] + D[i]), 0);
			}
		}
		return count;
	}
}
