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
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < firstList.length && j < secondList.length) {
			int[] arr1 = firstList[i];
			int[] arr2 = secondList[j];
			int start = Math.max(arr1[0], arr2[0]);
			int end = Math.min(arr1[1], arr2[1]);
			if (start <= end) {
				list.add(new int[]{start, end});
			}
			if (arr1[1] == end) {
				i++;
			}
			if (arr2[1] == end) {
				j++;
			}
		}
		return list.toArray(new int[list.size()][2]);
	}
}
