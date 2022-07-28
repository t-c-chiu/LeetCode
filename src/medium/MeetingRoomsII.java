package medium;

import java.util.Arrays;

public class MeetingRoomsII {
	
	public static void main(String[] args) {
		int res = minMeetingRooms(new int[][]{
				{7, 10},
				{2, 4},
				{1, 2},
				{3, 6},
				{4, 8},
		});
		System.out.println(res);
	}
	
	/**
	 * 1 2 3 4 7
	 * 2 4 6 8 10
	 */
	public static int minMeetingRooms(int[][] intervals) {
		int n = intervals.length;
		int[] start = new int[n], end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int res = 0;
		for (int i = 0, j = 0; i < n; i++) {
			if (start[i] < end[j]) {
				res++;
			}
		}
		return res;
	}
//	public static int minMeetingRooms(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
//		pq.offer(intervals[0]);
//		for (int i = 1; i < intervals.length; i++) {
//			if (pq.peek()[1] <= intervals[i][0]) {
//				pq.poll();
//			}
//			pq.offer(intervals[i]);
//		}
//		return pq.size();
//	}
}
