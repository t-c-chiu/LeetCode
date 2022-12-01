package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
	
	public static void main(String[] args) {
		int res = findMinDifference(Arrays.asList("23:59", "00:00"));
		System.out.println(res);
	}
	
	public static int findMinDifference(List<String> timePoints) {
		List<Integer> minutes = new ArrayList<>();
		for (String timePoint : timePoints) {
			minutes.add(toMinute(timePoint));
		}
		int res = Integer.MAX_VALUE;
		minutes.sort(Comparator.naturalOrder());
		for (int i = 1; i < minutes.size(); i++) {
			res = Math.min(res, minutes.get(i) - minutes.get(i - 1));
		}
		res = Math.min(res, minutes.get(0) + 1440 - minutes.get(minutes.size() - 1));
		return res;
	}
	
	private static Integer toMinute(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
}
