package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	
	public static void main(String[] args) {
	
	}
	
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				return false;
			}
		}
		return true;
	}
}
