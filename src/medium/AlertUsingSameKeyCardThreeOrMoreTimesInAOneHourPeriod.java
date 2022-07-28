package medium;

import java.util.*;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
	
	public static void main(String[] args) {
		List<String> res = alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
				new String[]{"10:00", "10:40", "11:00", "09:50", "10:20", "10:40", "15:00"});
		System.out.println(res);
	}
	
	public static List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<Integer>> map = new HashMap<>();
		int n = keyName.length;
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(keyName[i], new ArrayList<>());
			map.get(keyName[i]).add(compute(keyTime[i]));
		}
		List<String> res = new ArrayList<>();
		for (String name : map.keySet()) {
			List<Integer> times = map.get(name);
			times.sort(Comparator.naturalOrder());
			for (int i = 2; i < times.size(); i++) {
				if (times.get(i) - times.get(i - 2) <= 60) {
					res.add(name);
					break;
				}
			}
		}
		res.sort(Comparator.naturalOrder());
		return res;
	}
	
	private static Integer compute(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
	
}
