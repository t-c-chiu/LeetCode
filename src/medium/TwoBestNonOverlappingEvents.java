package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents {
	
	public static void main(String[] args) {
		int res = maxTwoEvents(new int[][]{{10, 83, 53}, {63, 87, 45}, {97, 100, 32}, {51, 61, 16}});
		System.out.println(res);
	}
	
	public static int maxTwoEvents(int[][] events) {
		Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		int res = 0, max = 0;
		for (int[] event : events) {
			int start = event[0];
			while (!pq.isEmpty() && pq.peek()[1] < start) {
				max = Math.max(max, pq.poll()[2]);
			}
			res = Math.max(res, max + event[2]);
			pq.offer(event);
		}
		return res;
	}
}
