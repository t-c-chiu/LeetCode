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
		int n = intervals.length;
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int endIdx = 0, room = 0;
		for (int i = 0; i < n; i++) {
			if (start[i] < end[endIdx]) {
				room++;
			} else {
				endIdx++;
			}
		}
		return room;
	}
	
}
