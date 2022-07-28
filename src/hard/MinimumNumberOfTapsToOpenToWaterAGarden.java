package hard;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
	
	public static void main(String[] args) {
		int res = minTaps(9, new int[]{0, 5, 0, 3, 3, 3, 1, 4, 0, 4});
		System.out.println(res);
	}
	
	public static int minTaps(int n, int[] ranges) {
		int[][] intervals = new int[n + 1][2];
		for (int i = 0; i < ranges.length; i++) {
			intervals[i] = new int[]{i - ranges[i], i + ranges[i]};
		}
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		int i = 0, end = Integer.MIN_VALUE;
		while (i < n + 1 && intervals[i][0] <= 0) {
			end = Math.max(end, intervals[i++][1]);
		}
		int res = 1;
		while (end < n && i < n + 1) {
			int newEnd = end;
			while (i < n + 1 && intervals[i][0] <= end) {
				newEnd = Math.max(newEnd, intervals[i][1]);
				i++;
			}
			if (newEnd == end) {
				return -1;
			}
			res++;
			end = newEnd;
		}
		return end >= n ? res : -1;
	}
}
