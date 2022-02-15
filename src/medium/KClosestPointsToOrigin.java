package medium;

import java.util.*;

public class KClosestPointsToOrigin {
	
	public static void main(String[] args) {
		int[][] res = kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
		Arrays.stream(res).forEach(
				arr -> {
					Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
					System.out.println();
				}
		);
	}
	
	public static int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
		for (int[] point : points) {
			pq.offer(point);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		return res;
	}
}
