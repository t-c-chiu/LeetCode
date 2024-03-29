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

//	public static int minMeetingRooms(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
//		for (int[] interval : intervals) {
//			if (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
//				pq.poll();
//			}
//			pq.offer(interval);
//		}
//		return pq.size();
//	}
	
	public static int minMeetingRooms(int[][] intervals) {
		int n = intervals.length;
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int rooms = 0, endIndex = 0;
		for (int i = 0; i < n; i++) {
			if (start[i] < end[endIndex]) {
				rooms++;
			} else {
				endIndex++;
			}
		}
		return rooms;
	}
	
	
}
