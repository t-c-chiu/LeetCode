package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
	
	public static void main(String[] args) {
		IntervalListIntersections test = new IntervalListIntersections();
		int[][] res = test.intervalIntersection(
				new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
				new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
		for (int[] arr : res) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			int start = Math.max(A[i][0], B[j][0]);
			int end = Math.min(A[i][1], B[j][1]);
			if (start <= end)
				list.add(new int[]{start, end});
			if (A[i][1] == end)
				i++;
			if (B[j][1] == end)
				j++;
		}
		int[][] res = new int[list.size()][2];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
}
