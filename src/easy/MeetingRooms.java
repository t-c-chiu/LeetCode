package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	
	public static void main(String[] args) {
	
	}
	
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1][1] > intervals[i][0]) {
				return false;
			}
		}
		return true;
	}
}
