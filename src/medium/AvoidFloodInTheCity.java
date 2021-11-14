package medium;

import java.util.*;

public class AvoidFloodInTheCity {
	
	public static void main(String[] args) {
		int[] res = avoidFlood(new int[]{69, 0, 0, 0, 69});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] avoidFlood(int[] rains) {
		int n = rains.length;
		int[] res = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> dry = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int lake = rains[i];
			if (lake == 0) {
				dry.add(i);
				res[i] = 1;
			} else {
				if (map.containsKey(lake)) {
					Integer day = dry.higher(map.get(lake));
					if (day != null) {
						res[day] = lake;
						dry.remove(day);
					} else {
						return new int[0];
					}
				}
				map.put(lake, i);
				res[i] = -1;
			}
		}
		return res;
	}
}
