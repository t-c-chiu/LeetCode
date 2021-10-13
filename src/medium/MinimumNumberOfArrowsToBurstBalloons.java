package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
	
	public static void main(String[] args) {
		int res = findMinArrowShots(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{4, 5},
		});
		System.out.println(res);
	}
	
	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
		int res = 1, shot = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= shot) {
				continue;
			}
			res++;
			shot = points[i][1];
		}
		return res;
	}
//	public static int findMinArrowShots(int[][] points) {
//		Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
//		int res = 1, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
//		for (int[] point : points) {
//			if (point[0] >= min && point[0] <= max || point[1] >= min && point[1] <= max) {
//				min = Math.max(min, point[0]);
//				max = Math.min(max, point[1]);
//			} else {
//				min = point[0];
//				max = point[1];
//				res++;
//			}
//		}
//		return res;
//	}
}
