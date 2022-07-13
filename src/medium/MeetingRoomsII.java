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
	
	public static int minMeetingRooms(int[][] intervals) {
		int n = intervals.length, res = 0;
		int[] start = new int[n], end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		for (int i = 0, endIdx = 0; i < n; i++) {
			if (start[i] < end[endIdx]) {
				res++;
			} else {
				endIdx++;
			}
		}
		return res;
	}
//	public static int minMeetingRooms(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
//		pq.offer(intervals[0]);
//		for (int i = 1; i < intervals.length; i++) {
//			int[] interval = intervals[i];
//			if (pq.peek()[1] <= interval[0]) {
//				pq.poll();
//			}
//			pq.offer(interval);
//		}
//		return pq.size();
//	}
}
