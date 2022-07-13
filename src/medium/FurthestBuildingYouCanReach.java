package medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
	
	public static void main(String[] args) {
		int res = furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1);
		System.out.println(res);
	}
	
	
	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		int n = heights.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < n; i++) {
			if (heights[i] > heights[i - 1]) {
				pq.offer(heights[i] - heights[i - 1]);
				if (pq.size() > ladders) {
					bricks -= pq.poll();
				}
				if (bricks < 0) {
					return i - 1;
				}
			}
		}
		return n - 1;
	}
}
