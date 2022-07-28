package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {
	
	public static void main(String[] args) {
		List<Integer> res = minAvailableDuration(
				new int[][]{{10, 50}, {60, 120}, {140, 210}},
				new int[][]{{0, 15}, {60, 70}},
				12);
		System.out.println(res);
	}
	
	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, Comparator.comparingInt(o -> o[1]));
		Arrays.sort(slots2, Comparator.comparingInt(o -> o[1]));
		int i = 0, j = 0;
		while (i < slots1.length && j < slots2.length) {
			int start = Math.max(slots1[i][0], slots2[j][0]);
			int end = start + duration;
			if (end <= slots1[i][1] && end <= slots2[j][1]) {
				return Arrays.asList(start, end);
			} else if (end > slots1[i][1]) {
				i++;
			} else {
				j++;
			}
		}
		return new ArrayList<>();
	}
}
