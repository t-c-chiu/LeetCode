package medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
	
	public static void main(String[] args) {
		int res = furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1);
		System.out.println(res);
	}
	
	
	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[i - 1]) {
				pq.offer(heights[i] - heights[i - 1]);
			}
			if (pq.size() > ladders) {
				int smallestGap = pq.poll();
				if (bricks >= smallestGap) {
					bricks -= smallestGap;
				} else {
					return i - 1;
				}
			}
		}
		return heights.length - 1;
	}
	
}
