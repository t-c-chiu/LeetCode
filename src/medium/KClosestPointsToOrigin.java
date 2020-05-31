package medium;

import java.util.*;

public class KClosestPointsToOrigin {
	
	public static void main(String[] args) {
		KClosestPointsToOrigin test = new KClosestPointsToOrigin();
		int[][] ans = test.kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
		ans = test.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
	}
	
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> queue =
				new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
		for (int[] point : points) {
			queue.offer(point);
			if (queue.size() > K)
				queue.poll();
		}
		
		int[][] result = new int[K][2];
		while (K > 0)
			result[--K] = queue.poll();
		return result;
	}
}
