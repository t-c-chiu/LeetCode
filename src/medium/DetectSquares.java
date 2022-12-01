package medium;

import java.util.ArrayList;
import java.util.List;

public class DetectSquares {
	
	public static void main(String[] args) {
		DetectSquares detectSquares = new DetectSquares();
		detectSquares.add(new int[]{3, 10});
		detectSquares.add(new int[]{11, 2});
		detectSquares.add(new int[]{3, 2});
		System.out.println(detectSquares.count(new int[]{11, 10}));
		// return 1. You can choose: The first, second, and third points
		System.out.println(detectSquares.count(new int[]{14, 8}));
		// return 0. The query point cannot form a square with any points in the data structure.
		detectSquares.add(new int[]{11, 2});    // Adding duplicate points is allowed.
		System.out.println(detectSquares.count(new int[]{11, 10}));
		// return 2. You can choose: The first, second, and third points. The first, third, and fourth points
	}
	
	int[][] count;
	List<int[]> points;
	
	public DetectSquares() {
		count = new int[1001][1001];
		points = new ArrayList<>();
	}
	
	public void add(int[] point) {
		count[point[0]][point[1]]++;
		points.add(point);
	}
	
	public int count(int[] point) {
		int res = 0, x1 = point[0], y1 = point[1];
		for (int[] p : points) {
			int x3 = p[0], y3 = p[1];
			if (x1 != x3 && y1 != y3 && Math.abs(x1 - x3) == Math.abs(y1 - y3)) {
				res += count[x1][y3] * count[x3][y1];
			}
		}
		return res;
	}
}
