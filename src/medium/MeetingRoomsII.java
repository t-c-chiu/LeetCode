package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		if (intervals.length == 0) {
			return 0;
		}
		
		Arrays.sort(intervals, ((o1, o2) -> {
			if (o1[0] < o2[0]) {
				return -1;
			} else if (o1[0] > o2[0]) {
				return 1;
			} else {
				return o1[1] - o2[1];
			}
		}));
		PriorityQueue<int[]> rooms = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		rooms.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] nextRoom = intervals[i];
			int[] earliestRoom = rooms.peek();
			if (nextRoom[0] >= earliestRoom[1]) {
				rooms.poll();
			}
			rooms.offer(nextRoom);
		}
		return rooms.size();
	}
}
