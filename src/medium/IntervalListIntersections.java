package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
	
	public static void main(String[] args) {
		int[][] res = intervalIntersection(
				new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
				new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
		for (int[] arr : res) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int i = 0, j = 0;
		List<int[]> list = new ArrayList<>();
		while (i < firstList.length && j < secondList.length) {
			int[] A = firstList[i], B = secondList[j];
			int start = Math.max(A[0], B[0]);
			int end = Math.min(A[1], B[1]);
			if (start <= end) {
				list.add(new int[]{start, end});
			}
			if (A[1] == end) {
				i++;
			}
			if (B[1] == end) {
				j++;
			}
		}
		int[][] res = new int[list.size()][2];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
}
