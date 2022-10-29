package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
	
	public static void main(String[] args) {
		int res = jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70});
		System.out.println(res);
	}
	
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
		}
		Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 0);
		for (int[] job : jobs) {
			int max = Math.max(map.lastEntry().getValue(), map.floorEntry(job[0]).getValue() + job[2]);
			map.put(job[1], max);
		}
		return map.lastEntry().getValue();
	}
}
