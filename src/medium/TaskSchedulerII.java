package medium;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
	
	public static void main(String[] args) {
		long res = taskSchedulerII(new int[]{5, 8, 8, 5}, 2);
		System.out.println(res);
	}
	
	public static long taskSchedulerII(int[] tasks, int space) {
		Map<Integer, Long> lastDay = new HashMap<>();
		long day = 0;
		for (int i = 0; i < tasks.length; i++) {
			int type = tasks[i];
			if (lastDay.containsKey(type) && lastDay.get(type) + space >= day) {
				day = lastDay.get(type) + space;
			}
			day++;
			lastDay.put(type, day);
		}
		return day;
	}
}
